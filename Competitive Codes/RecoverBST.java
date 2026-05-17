
import java.util.*;

public class RecoverBST {
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
    static Node prev = null, first = null, second = null;
    public static void create(String a[]){
        if(a[0].equals("N")|| a.length == 0) return;
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

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.data < prev.data){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

    public static Node recoverTree(Node root){
        if(root == null) return root;
        inorder(root);
        if(first != null && second != null){
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
        return root;
    }

    public static void display(Node root){
        if(root == null) return;
        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        String a[] = s.split(" ");
        create(a);
        display(root);
        System.out.println();
        root = recoverTree(root);
        display(root);
        System.out.println();
    }

}
