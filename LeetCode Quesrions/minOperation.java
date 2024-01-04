// Leetcode problem of the day 04-01-2024
// Question link : https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/?envType=daily-question&envId=2024-01-04

import java.util.*;

public class minOperation {
    
    public static int minOperations(int[] nums) {
        int ans = 0;
        // create a hashmap & store element with their frequency
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        // creating Set to loop all the element
       Set<Integer> keys = hm.keySet();
       for (Integer k : keys) {
            int freq = hm.get(k);
            // base case
            if(freq < 2){
                return -1;
            }

            // rest cases
            while (freq !=0) {
                if(freq%3 == 0){    // multiple of 3
                    ans += freq/3;
                    freq = 0;
                }else{  // reduce 2 & add as one operation
                    freq = freq -2;
                    ans++;
                }
            }
       }
        
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {2,3,3,2,2,4,2,3,4};
       System.out.println(minOperations(nums));
    }
}
