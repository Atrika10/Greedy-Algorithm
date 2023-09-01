import java.util.*;

public class MinPlatForm {

    // TC => O(nlogn) + O(n)
    public static int findPlatform(int arr[], int dep[], int n) {
        // sort both the arrays   TC => O(2nlogn) => O(nlogn)
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformNeeded = 1; int minPlatform = 1;
        // taking 2 pointer
        int i=1, j=0;

        while (i < n && j<n) {   // TC => O(2n) => O(n), as both the pointer is traversing both arrays
            
            if (arr[i] <= dep[j]) {
                platformNeeded++;
                i++;
            }else if (arr[i] > dep[j]){
                platformNeeded--;
                j++;
            }

            // compare
            if (platformNeeded > minPlatform) {
                minPlatform = platformNeeded;
            }
        }
        return minPlatform;
    }

    public static void main(String[] args) {
        int n = 6;
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(findPlatform(arr, dep, n));
    }
}
