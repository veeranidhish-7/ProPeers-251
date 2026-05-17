import java.util.*;
public class LCS {
    static int dp[][];

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        dp = new int[s1.length()+1][s2.length() + 1];
        lcs(s1,s2,dp);
    }

    public static void lcs(String s1, String s2, int dp[][]){
        int i = s1.length();
        int j = s2.length();

        for(int x = 1; x<= s1.length(); x++){
            for(int y = 1; y<=s2.length(); y++){
                if(s1.charAt(x-1) == s2.charAt(y-1)){
                    dp[x][y] = 1 + dp[x-1][y-1];
                }else{
                    dp[x][y] = Math.max(dp[x-1][y],dp[x][y-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(i>0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println("Length is: "+sb.toString().length());
        System.out.println("String is: "+sb.reverse().toString());
    }
}
