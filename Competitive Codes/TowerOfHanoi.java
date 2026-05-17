import java.util.*;
public class TowerOfHanoi {
    public static void toh(int disks){
        Stack<Integer> src = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        Stack<Integer> dest = new Stack<>();

        char s='S', a = 'A', d = 'D';

        if(disks%2 ==0){
            char t = a;
            a = d;
            d = a;
        }
        for(int i = disks; i>0; i--){
            src.push(i);
        }

        int steps = (int) Math.pow(2,disks) - 1;

        for(int i = 1; i<=steps; i++){
            if(i%3 == 1){
                moveDisks(src,dest,s,d);
            }else if(i%3 == 2){
                moveDisks(src,aux,s,a);
            }else{
                moveDisks(aux,dest,a,d);
            }
        }

    }

    public static void moveDisks(Stack<Integer> a, Stack<Integer> b, char s, char d){
        if(a.isEmpty()){
            int disk = b.pop();
            System.out.println(s+" " +d);
            a.push(disk);
        }else if(b.isEmpty()){
            int disk = a.pop();
            System.out.println(s + " "+d);
            b.push(disk);
        }else if(a.peek() < b.peek()){
            int disk = a.pop();
            System.out.println(s + " " + d);
            b.push(disk);
        }else{
            int disk = b.pop();
            System.out.println(s + " " + d);
            a.push(disk);
        }
    }
}
