import java.util.*;
public class MaxPairChain {

    // Tc => O(nlogn)
    public static int maxLengthChainOfPair(int pair[][]){
        /*  As I can select a pair whose first number is greater than the last number of my selected pair;
         I've to sort pair array by 2nd number */
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));  // O(logn)

        // select first pair as this pair has smallest 2nd number
        int lastEnd = pair[0][1];
        int ans =1;

        for (int i = 1; i < pair.length; i++) {   // O(n)
            if (pair[i][0] >= lastEnd) {       // first number of my current pair is greater/equal to lastend
                ans++;
                // update last end as I've selected this pair
                lastEnd = pair[i][1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int pair[][] = {{5,24}, {5,28},{27,40},{39,60},{50,90}};
        System.out.println("max length of pairs : " + maxLengthChainOfPair(pair));
    }
}
