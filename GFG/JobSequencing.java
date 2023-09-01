import java.util.*;

public class JobSequencing {

    static class Job {
        int id;
        int deadline;
        int profit;

        Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }

    // Time Complexity => O(nlogn) + O(n*m); where n= arr.length & m = max deadline
    // n*m = n no of iteration * max deadline
    // Space complexity => O(m);  m= maximum deadline that I can have for any job
    public static int[] JobScheduling(Job arr[], int n) {
        int ans[] = new int[2];

        // object sorting on the basis of profit
        Arrays.sort(arr, (obj1, obj2) -> obj2.profit - obj1.profit);

        // find max deadline available
        int maxDeadline = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }

        // create an array where we'll store the sequence of the job can be performed
        int jobSequence[] = new int[maxDeadline + 1];
        for(int i=0; i<jobSequence.length;i++){
            jobSequence[i] = -1;
        }

        int maxProfit = 0;
        int jobCount = 0;
        for (int i = 0; i < n; i++) {

            for (int j = arr[i].deadline; j > 0; j--) { // j will iterated from the last day to first day (in worst
                                                        // case)
                // wherever i'll get free slot I'll keep that job there
                if (jobSequence[j] == -1) {
                    jobSequence[j] = arr[i].id;
                    jobCount++;
                    maxProfit += arr[i].profit;
                    break; // I've added job in my jobSequence array so I'll break from here & check next job
                }
            }
        }
        ans[0] = jobCount;
        ans[1] = maxProfit;
        return ans;
    }

    public static void main(String[] args) {
        int N = 4;
        int Jobs[][] = { { 1, 4, 20 }, { 2, 1, 10 }, { 3, 1, 40 }, { 4, 1, 30 } };
        Job arr[] = new Job[Jobs.length];

        for (int i = 0; i < Jobs.length; i++) {
            arr[i] = new Job(Jobs[i][0], Jobs[i][1], Jobs[i][2]);
        }
        JobScheduling(arr, N);
    }
}
