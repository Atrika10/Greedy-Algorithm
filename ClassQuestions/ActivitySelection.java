import java.util.*;
public class ActivitySelection{

    // Time complexity will be O(nlogn)
    public static void main(String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2, 4, 6, 7, 9, 9};   

        //As end time is unsorted, we need to sort first
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;   // in col 0 I'm storing index of activities
            activities[i][1] = start[i]; // start time in 1st column
            activities[i][2] = end[i];  // end time in 2nd column
        }

        // sort this 2d Array , TC => logN
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));      // it will sort accoring to 2nd column

        int maxActivity = 0;
        ArrayList<Integer> Al = new ArrayList<>();

        // As I already have activities in sorted fashion by their end time
        // I can pick first activity, so that I can get more time to complete other activity
        
        // 1st Activity
        maxActivity = 1;
        Al.add(activities[0][0]);   // adding selcted activities idx
        int lastend = activities[0][2];  // storing my last choosen activity, so that I can compare it with my next activity
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastend) {    // non overlapping condition; I can select this Activity
                maxActivity++;
                Al.add(activities[i][0]);

                // update lastend, after selecting current activity
                lastend = activities[i][2];   // end time of my selected activity
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