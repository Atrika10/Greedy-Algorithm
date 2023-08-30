import java.util.*;
public class FurthestHouse {

    public static int maxDistance(int[] colors) {
        int first = 0;
        int last = colors.length-1;
        int max = 0;

        // comparing the first house with other house from end, as I've to return max distance btw 2 different house
        for (int i = 0; i < colors.length; i++) {
            if (colors[first] != colors[last]) { // I got the max distance
                max = Math.max(max,Math.abs(first-last)) ;
            }else{
                last--;
            }
        }

        // // comparing the last house with other house from first,
        first = colors.length-1;
        last = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[first] != colors[last]) { // I got the max distance
                max = Math.max(max,Math.abs(first-last)) ;
            }else{
                last++;
            }
        }
        return max; // return max distance
    }

    public static void main(String[] args) {
        int colors[] = {4,4,4,11,4,4,11,4,4,4,4,4};
        System.out.println(maxDistance(colors));
    }
    
}
