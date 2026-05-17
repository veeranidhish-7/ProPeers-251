import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        double m = med(arr);
        System.out.println(m);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static double med(int[] arr){
        double median = 0;
        int n = arr.length;
        if(n%2==0){
            double a = (arr[n/2]);
            double b = (arr[n/2-1]);
            median = (a+b)/2;
        }else{
            median = (arr[n-1]-1)/2;
        }
        return median;
    }
}