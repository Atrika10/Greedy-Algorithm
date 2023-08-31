import java.util.*;
public class Nmeeting {

    // Time complexity => O(nlogn)

    public static int maxMeetings(int start[], int end[], int n){
        int maxMeetingNo =0;
        int lastEnd = 0;

        int arr[][] = new int[n][3]; // n no of row & col no = 3;
        for (int i = 0; i < start.length; i++) {
            arr[i][0] = i;
            arr[i][1] = start[i];
            arr[i][2] = end[i];
        }

        /* As I want to conduct max meeting in a room, 
        I'll choose those meetings which will be ending earlier.
        That's why I'll sort array on the basis of meeting's end time  */

        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2])); // O(nlogn)

        // I'll pick the first meeting as this will be ending first
        lastEnd = arr[0][2];
        maxMeetingNo++;

        for (int i = 1; i < start.length; i++) {    // O(n)
            
            if (arr[i][1] > lastEnd ) {  // if end time of last meeting is greater than start time of current meeting, I can choose this meeting
                maxMeetingNo++;
                lastEnd = arr[i][2];
            }
        }
        return maxMeetingNo;
    }

    public static void main(String[] args) {
        int N = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = { 2,4,6,7,9,9 };
        System.out.println(maxMeetings(start, end, N));
    }

}
