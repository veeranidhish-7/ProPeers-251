package Arrays;

public class SecondGreatest {
    public static void main(String[] args) {
        int arr[] = {10,10};
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int n = arr.length;

        for(int i = 0; i<n; i++){
            if(arr[i] > max){
                ans = max;
                max = arr[i];
            }else if(arr[i] > ans && arr[i] <= max){
                ans = arr[i];
            }
        }
        System.out.println(ans);
    }
}
