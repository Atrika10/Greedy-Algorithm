import java.util.*;
public class MaximizeSum {

    // Time complexity => O(nlogn), where n is the length of nums array

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums); // accending order TC => O(nlogn)

        for (int i = 0; i < nums.length; i++) { //O(n)
            if (nums[i] < 0 && k>0) {           //if my min number is negative & k > 0, then I'll perform given operation which is filp the sign
                nums[i] = -nums[i];
                k--;    // update k as I've performed 1 operation
            }
        }

        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {     //O(n)
            maxSum += nums[i];
        }

        // if still I've k>0 && k is odd, then I'll pick min number and will change it's sign
        int min = 0;
        if (k%2 !=0) { // K is odd
            for (int i = 1; i < nums.length; i++) {     //O(n)
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }

            maxSum -= 2*nums[min]; // first exclude min number from sum & then include min number by changing it's sign
        }
        
        return maxSum;
    }
    public static void main(String[] args) {
        int nums[] = {3,-1,0,2}, k = 3;
        System.out.println("Max sum : " + largestSumAfterKNegations(nums, k));
    }
}
