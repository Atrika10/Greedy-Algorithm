import java.util.*;
public class MinAbsDiffPair {

    public static int minAbsoluteDiffPair(int A[], int B[]){
        // As we need min differences of all pairs, we need to have sorted array in accending order.
        /* by subtracting the elements which are closer, we get the min sum */
        Arrays.sort(A);     // O(logn)
        Arrays.sort(B);     // O(logn)
        int minSum =0;
        for (int i = 0; i < B.length; i++) {  // O(n)
            minSum += Math.abs(A[i]-B[i]);
        }
        return minSum;
    }

    public static void main(String[] args) {
        int A[] = {10,25,31};
        int B[] = {50,2,16};
        System.out.println(minAbsoluteDiffPair(A, B));
    }
}
