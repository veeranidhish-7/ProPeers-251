package Arrays;

public class NonDecreasing {
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        if(nums.length <= 2){
            return true;
        }
        
        for(int i = 1; i<nums.length; i++){
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) return false;

                // Decide which way to fix the dip
                if (i >= 2 && nums[i] < nums[i - 2]) {
                    // Situation: [3, 4, 2] -> The '2' is too low, must raise it
                    nums[i] = nums[i - 1]; 
                } else {
                    // Situation: [-1, 4, 2] or [4, 2, 3] -> Can lower the '4'
                    nums[i - 1] = nums[i]; 
                }
            }
        }
        if(count >= 2) return false;
        // if(count <= 1) return true;
        return true;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,2};
        System.out.println(checkPossibility(arr));
    }
}
