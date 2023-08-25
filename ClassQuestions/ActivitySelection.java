import java.util.*;
public class ActivitySelection{
    public static void main(String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2, 4, 6, 7, 9, 9};   // end time is sorted

        // step -1 
        int maxActivity = 0;
        ArrayList<Integer> Al = new ArrayList<>();

        // As I already have activities in sorted fashion by their end time
        // I can pick first activity, so that I can get more time to complete other activity
        
        maxActivity = 1;
        Al.add(0);   // adding selcted activities idx
        int lastend = end[0];  // storing my last choosen activity, so that I can compare it with my next activity
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastend) {    // non overlapping condition; I can select this Activity
                maxActivity++;
                Al.add(i);

                // update lastend, after selecting current activity
                lastend = end[i];   // end time of my selected activity
            }
        }

        // if I want to print the idx of activity which I've selected
        for (int i = 0; i < Al.size(); i++) {
            System.out.print( "A"+ Al.get(i) + " ");
        }
        System.out.println();

        System.out.println("max Activity : "+ maxActivity);
    }
}