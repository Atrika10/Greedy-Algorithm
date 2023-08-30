import java.util.*;
public class MaxUnits {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort on the basis of units, as I've to maximize the no of units
        Arrays.sort(boxTypes, Comparator.comparingDouble(o -> o[1]));  
        int totalUnit = 0;
        
        for (int i = boxTypes.length-1; i >= 0; i--) {
            // if trucksize is greater than no of box in current idx; I can add all box in truck
            if (truckSize >= boxTypes[i][0]) { 
                // total include
                totalUnit += (boxTypes[i][0]* boxTypes[i][1]);
                truckSize -= boxTypes[i][0];
            }
            else{       // otherwise I'll add whatever the truck size I've left with no of units of per box
                totalUnit += (truckSize*boxTypes[i][1]);
                truckSize = 0;
            }
        }
        return totalUnit;
    }
    
    public static void main(String[] args) {
        int boxTypes[][] = {{5,10},{2,5},{4,7},{3,9}}, truckSize = 10;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}
