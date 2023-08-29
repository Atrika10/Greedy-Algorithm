/*
 * We have two variables L and R, indicating a range of integers from L to R inclusive, and a
number K, the task is to find Kth largest odd number. If K > number of odd numbers in the range
L to R then return 0
 */
import java.util.*;
public class KthLargestOddNumber {

    // Time complexity => O(n), where n is the difference between R & L
    public static int KthLargestOddNumberInARange(int L, int R, int k){
        while (R >= L && k!=0) {
            if (R%2 != 0) {         //if it is odd number
                k--;
                if (k == 0) {
                    return R; // because now R is my kth odd number
                }
            }
            R--;
        }

        return 0; // If K > number of odd numbers in the range L to R
    }

    public static void main(String[] args) {
        int L = -3, R = 3, K =2;
        System.out.println("Kth largest Odd number in the range : " + KthLargestOddNumberInARange(L, R, K));
    }
    
}
