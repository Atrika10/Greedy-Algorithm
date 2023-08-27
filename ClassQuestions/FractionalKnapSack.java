import java.util.*;
public class FractionalKnapSack {

    // Time complexity will be O(nlogn)
    public static void main(String[] args) {
        int weight[] = {10,20,30};
        int value[] = {60,100,120}; 
        int w = 50;

        //  calculate ratio
        double ratio[][] = new double[value.length][2];
        // 0th col => idx; 1st col => ratio
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));  // it will give me sorted array in accending order

        int capacity = w;
        int finalValue =0;
        for (int i = ratio.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];

            if (capacity >= weight[idx]) {
                // include total weight
                finalValue += value[idx];
                capacity -= weight[idx];
            }else{
                // include fractional weight
                finalValue += (ratio[i][1]*capacity);
                capacity =0;
                break;
            }
            
        }
        System.out.println( " final value I can add: " + finalValue);
    }
    
}
