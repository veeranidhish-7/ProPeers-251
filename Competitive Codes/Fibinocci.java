import java.util.*;
public class Fibinocci {
    static int dp[];

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        dp[0] = 0;
        if(n >= 1){
            dp[1] = 1;
        }
        System.out.println(fib(n));
    }

    public static int fib(int n){
        if(n < 2){
            return dp[n];
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = fib(n-1) + fib(n-2);
    }



}
