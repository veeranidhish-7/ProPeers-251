import java.util.*;
public class Subset {
    static boolean dp[][];
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        dp = new boolean[n+1][target+1];
        System.out.println(subset(arr,target));
    }

    public static boolean subset(int arr[], int target){
        for(int i = 0; i<=arr.length; i++){
            dp[i][0] = true;
        }


        for(int i = 1; i<=arr.length; i++){
            for(int j = 1; j<=target; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][target];
    }
}
