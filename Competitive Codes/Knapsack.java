import java.util.*;
public class Knapsack {
    static int dp[][];

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w[] = new int[n];
        int p[] = new int[n];

        for(int i = 0; i<n; i++){
            w[i] = sc.nextInt();
        }

        for(int i = 0; i<n; i++){
            p[i] = sc.nextInt();
        }

        int cap = sc.nextInt();
        dp = new int[n+1][cap+1];
        knapsack(n,w,p,cap);

//        System.out.println(dp[n][cap]);
    }

    public static void knapsack(int n, int w[], int p[], int cap){
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=cap; j++){
                if(w[i-1] <= j){
                    int take = p[i-1] + dp[i-1][j-w[i-1]];
                    int nottake = dp[i-1][j];
                    dp[i][j] = Math.max(take,nottake);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][cap]);
    }
}
