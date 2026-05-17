import java.util.*;

public class VerticalOrderTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Qnode{
        Node node;
        int v;
        int l;
        Qnode(Node node, int v, int l){
            this.node = node;
            this.v = v;
            this.l = l;
        }
    }

    static Node root;

    public static Node create(Node root,int data){
        if(root == null){
            return new Node(data);
        }else if(data > root.data){
            root.right = create(root.right,data);
        }else if(data < root.data){
            root.left = create(root.left,data);
        }

        return root;
    }

    public static void verticalTraversal(Node root){
        TreeMap<Integer,TreeMap<Integer, LinkedList<Integer>>> map = new TreeMap<>();
        Queue<Qnode> q = new LinkedList<>();
        q.add(new Qnode(root,0,0));

        while(!q.isEmpty()){
            Qnode curr = q.poll();
            int ver = curr.v;
            int level = curr.l;

            map.putIfAbsent(ver,new TreeMap<>());
            map.get(ver).putIfAbsent(level,new LinkedList<>());
            map.get(ver).get(level).add(curr.node.data);

            if(curr.node.left != null){
                q.add(new Qnode(curr.node.left,ver-1,level+1));
            }

            if(curr.node.right != null){
                q.add(new Qnode(curr.node.right, ver+1,level+1));
            }
        }

//        System.out.println(map);

        for(Map.Entry<Integer,TreeMap<Integer,LinkedList<Integer>>> vertical : map.entrySet()){

            System.out.println("Vertical Entry: "+vertical.getKey());

            for(Map.Entry<Integer,LinkedList<Integer>> level : vertical.getValue().entrySet()){
                System.out.println("Level " + level.getKey() + " -> " + level.getValue());
            }

        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            root = create(root,sc.nextInt());
        }
        verticalTraversal(root);
    }
}
