import java.util.*;
public class FractionalKnapSack {

    public static void main(String[] args) {
        int weight[] = {10,20,30};
        int value[] = {60,100,120}; 
        int w = 50;

        // ratio calculate, as I want max value & min weight
        int ratio[] = new int[value.length];
        for (int i = 0; i < value.length; i++) {
            ratio[i] = value[i]/weight[i];
        }

        int capacity = w;
        int maxValue =0;
        for (int i = 0; i < ratio.length; i++) {
            if (capacity >= weight[i]) {
                // I can include total item
                capacity -= weight[i];         // means I've added this item
                maxValue += value[i];
            }else{
                // I've less capacity of current item's weight
                maxValue += ratio[i]*capacity;
                capacity =0;
                break;
            }
        }
        System.out.println( " max value I can add: " + maxValue);
    }
    
}
