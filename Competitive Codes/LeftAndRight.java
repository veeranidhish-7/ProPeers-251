import java.util.*;
public class LeftAndRight {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static Node root;
    static ArrayList<Integer> l = new ArrayList<>();
    static ArrayList<Integer> r = new ArrayList<>();

    public static void leftView(Node root,int size){
        if(root == null) return;
        if(size == l.size()){
            l.add(root.data);
        }

        if(root.left != null){
            leftView(root.left,size+1);
        }

        if(root.right != null){
            leftView(root.right,size+1);
        }
    }

    public static void rightView(Node root, int size){
        if(root == null) return;
        if(size == r.size()){
            r.add(root.data);
        }
        if(root.right != null){
            rightView(root.right,size+1);
        }
        if(root.left != null){
            rightView(root.left,size+1);
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
