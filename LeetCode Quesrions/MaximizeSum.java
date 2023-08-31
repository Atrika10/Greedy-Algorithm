public class MaximizeSum {
    public static int largestSumAfterKNegations(int[] nums, int k) {

        int minIdx = 0; // assuming first element in min
        while (k != 0) {                                // O(k*n)
            for (int i = 1; i < nums.length; i++) {
                if(nums[minIdx] > nums[i]){
                    minIdx = i;
                }
            }
            // after getting min idx, I've to change the sign
            nums[minIdx] = -nums[minIdx];
            k--;
        }

        // calculate sum
        int maxSum =0;
        for (int i = 0; i < nums.length; i++) {      // O(n)
            maxSum += nums[i];
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int nums[] = {2,-3,-1,5,-4}, k = 2;
        System.out.println("Max sum : " + largestSumAfterKNegations(nums, k));
    }
}
