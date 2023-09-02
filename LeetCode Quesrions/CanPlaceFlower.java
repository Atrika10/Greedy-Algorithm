import java.util.*;
public class CanPlaceFlower {

    // Time complexity => O(n), where n is the length of the given array
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int  i =0, j=1;
        int ln = flowerbed.length;

        // edge cases
        if (ln == 0 && n==0) {
            return true;
        }else if(ln == 0 && n>0){
            return false;
        }else if(ln == 1 && flowerbed[0] == 0 && n<=1){
            return true;
        }else if(ln == 1 && flowerbed[0] == 1 && n==0){
            return true;
        }else if(ln == 1 && flowerbed[0] == 1 && n>0){
            return false;
        }

        while (i<ln-2 && j < ln-1 & n != 0) {
            if (i == 0 && (flowerbed[i] == 0 && flowerbed[j] == 0)) {    // I'll check only right side
                flowerbed[i]  = 1;
                n--;
                i++; j++;
            }else{

                if (flowerbed[i] == 0 && flowerbed[j] == 0 && flowerbed[j+1] == 0) { // I can plant a flower in j th idx
                    flowerbed[j] = 1;
                    n--;
                }
                i++;j++;
            }
        }

        if(n!=0) {
            if (flowerbed[i] == 0 && flowerbed[j] == 0) {       // can i place a plant in last idx (checking only left side)
                flowerbed[j] = 1;
                n--;
            }
        }
        if (n == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int flowerbed[] = {1,0,0,0,1}, n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
