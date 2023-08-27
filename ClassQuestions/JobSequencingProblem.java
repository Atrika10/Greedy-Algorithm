import java.util.*;
public class JobSequencingProblem {

    // Time Complexity => O(nlogn)
    public static int maxProfit(int jobs[][]){
        // I've to sort this array based on profit
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1])); // accending

        int finalProfit = 0;
        int time =0;

        // select first job as it will give max profit
        finalProfit += jobs[jobs.length-1][1];
        time++;
        for (int i = jobs.length-2; i >= 0; i--) {
            if (jobs[i][0] > time) { // select the job as deadline hasn't passed
                finalProfit += jobs[i][1];
                time++;
            }
        }
        return finalProfit;
    }

    public static void main(String[] args) {
        int jobs[][] = {{4,20},{1,10},{1,40},{1,30}};
        System.out.println(maxProfit(jobs));
    }
}
