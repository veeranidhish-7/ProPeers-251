import java.util.*;
public class BoundaryTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static Node root;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void boundaryTraversal(Node root){
        if(root == null){
            return;
        }
        if(!isLeaf(root)){
            ans.add(root.data);
        }

        addLeft( root);
        addLeaf( root);
        addRight( root);
    }

    public static boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }

    public static void addLeft(Node root){
        Node curr = root.left;

        while(curr != null){
            if(!isLeaf(curr)){
                ans.add(curr.data);
            }

            if(curr.left != null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }

    public static void addLeaf(Node root){
        if(root == null) return;

        if(isLeaf(root)){
            ans.add(root.data);
        }

        addLeaf(root.left);
        addLeaf(root.right);
    }

    public static void addRight(Node root){
        Stack<Integer> st = new Stack<>();
        Node curr = root.right;

        while(curr != null){
            if(!isLeaf(curr)){
                st.push(curr.data);
            }

            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        while(!st.isEmpty()){
            ans.add(st.pop());
        }
    }

    public static void buildTree(String a[]){
        if(a.length == 0 || a[0].equals("N")){
            return;
        }
        root = new Node(Integer.parseInt(a[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(i < a.length && !a[i].equals("N")){
                curr.left = new Node(Integer.parseInt(a[i]));
                q.add(curr.left);
            }
            i++;
            if(i < a.length && !a[i].equals("N")){
                curr.right = new Node(Integer.parseInt(a[i]));
                q.add(curr.right);
            }
            i++;
        }
    }

    public static Node create(Node root,int d){
        if(root == null){
            return new Node(d);
        }else if(d < root.data){
            root.left = create(root.left,d);
        }else{
            root.right = create(root.right,d);
        }
        return root;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        String a[] = s.split(" ");
        buildTree(a);
        boundaryTraversal(root);
        System.out.println(ans);

    }
}
