import java.util.*;
public class AssignCookies {

    //Time complexity =>  O(max (m*log(m), n*log(n)) ) 
    public static int findContentChildren(int[] g, int[] s) {
        // sort in accending order
        Arrays.sort(g);   // O(m*log(m)
        Arrays.sort(s);    // O(n*log(n) 

        int i = 0, j=0, count =0;  // i & j will be my pointer for greed factor & cookies respectively.
        while(i < g.length && j <s.length){ // O(n+m)
            if (s[j] >= g[i]) { // satisfy our conditions
                // I can assign cookie
                count++;
                i++;j++;       // as I've assign cookies to a child, I've to increase pointers by 1;
            }else{
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int g[] = {1,2}, s[] = {1,2, 3};
        System.out.println(findContentChildren(g, s));
    }
}
