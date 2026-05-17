import java.util.*;
public class LIS {
    static int dp[];

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(lis(arr));
    }

    public static int lis(int arr[]){
        int max = 1;
        int n = arr.length;

        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }



        return max;
    }

}
