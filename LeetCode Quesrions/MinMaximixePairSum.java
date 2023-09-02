import java.util.*;
public class MinMaximixePairSum {

    // O(nlogn) + O(n)  => O(nolgn)
    public static int minPairSum(int[] nums) { // nums is even length 
        // sort in accending order
        Arrays.sort(nums);     // O(nlogn)
        int max = Integer.MIN_VALUE;
        int j = nums.length-1;

        for (int i = 0; i < nums.length/2; i++) { // loop will run n/2 time as Each element of nums is in exactly one pair
            int sum = nums[i]+nums[j];
            max = Math.max(max, sum);
            j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {3,5,2,3};
        System.out.println(minPairSum(nums));
    }
    
}
