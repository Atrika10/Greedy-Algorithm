import java.util.*;
public class ChocolaProblem{

    // TC=> O(n*log(n)) + O(m*log(m)), where n & m is the length of costHor & costVer (given Arrays) respectively
    public static void main(String[] args) {
        // int n=4, m =6;  n = row & m= column
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        //sort given arrays in decending order
        Arrays.sort(costVer, Collections.reverseOrder()); 
        Arrays.sort(costHor, Collections.reverseOrder());

        // taking 2 pointers which will track the order of cut
        int h=0; // track horizontal cut
        int v=0; // track vertical cut

        // taking 2 pointers which will track the pieces of chocolate after each cut
        int hp=1;   // initially, we will have 1 horizontal & vertical piece
        int vp=1;

        int cost =0 ; // to store min cost

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {   // expenive cut first
                cost += (costHor[h]*vp);      // horizontal cut will pass through all vertical pieces
                hp++;                   // after a horizontal cut, horizontal pieces will increase by 1
                h++;                // move pointer by one as this cut has been done
            }else{
                cost += (costVer[v]*hp);    // vertical cut will pass through all horizontal pieces
                vp++;                       // vertical pieces will increase by 1
                v++;
            }
        }

        // if I've some horizontal cut left
        while (h < costHor.length) {
            cost += (costHor[h]*vp);
            hp++;                  
            h++; 
        }
        // if I've some vertical cut left
        while (v < costVer.length) {
            cost += (costVer[v]*hp);
            vp++;                  
            v++; 
        }
        System.out.println("min cost to make chocolate bars into squares : " + cost);
    }
}