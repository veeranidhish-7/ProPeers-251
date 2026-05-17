import java.util.*;
public class Celebrity {
    public static boolean knows(int a, int b, int mat[][]){
        return mat[a][b] == 1;
    }

    public static void celebrity(int mat[][]){
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            st.push(i);
        }
        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            if(knows(a,b,mat)){
                st.push(b);
            }else{
                st.push(a);
            }
        }
        int c = st.pop();

        for(int i = 0; i<n; i++){
            if(i !=c && knows(c,i,mat) || !(knows(i,c,mat))){
                System.out.println("Not celebrity");
                return;
            }
        }
        System.out.println("celebrity");
    }
}
