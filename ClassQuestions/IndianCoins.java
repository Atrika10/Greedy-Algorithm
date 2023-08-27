import java.util.*;
public class IndianCoins {

    // Time complexity => O(nlogn),  where 'n' is the number of coins. 
    public static int minCoinToMakeChange(int coins[], int value){
        Arrays.sort(coins); // O(nlogn)
        // Arrays.sort(coins, Comparator.reverseOrder());
        int minCoin = 0;
         for (int i = coins.length-1; i >= 0; i--) {  // we need the largest note/coin first as we've to give min no of coins
             while (value != 0 && value >= coins[i]) {
                 minCoin++;
                  // System.out.println(coins[i]); //you can print those coins which is being added 
                 value -= coins[i];
             }
         }
        return minCoin;
    }

    public static void main(String[] args) {
        int coins[]  = {1,2,5,10,20,50,100,500,2000};
        int value = 590;
        System.out.println(minCoinToMakeChange(coins, value)); 
    }
}
