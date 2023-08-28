import java.util.*;
public class JobSequencingProblem {

    static class Job{
        int idx;
        int deadline;
        int profit;

        Job(int i, int d, int p){
            this.idx = i;
            this.deadline = d;
            this.profit = p;
        }
    }

    // Time Complexity => O(nlogn)
    public static int maxProfit(int jobs[][]){
        ArrayList<Job> jobsInfo = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            jobsInfo.add(new Job(i, jobs[i][0], jobs[i][1]));
        }

        // object sorting
        Collections.sort(jobsInfo, (obj1,obj2) -> obj2.profit-obj1.profit);    // decending order

        // To store the index of selected job
        ArrayList<Integer> selectedJob = new ArrayList<>();

        int Time = 0;
        int maxProfit =0;
        
        for (int i = 0; i < jobs.length; i++) {
            Job currJob = jobsInfo.get(i);   // it will give me id, deadline & profit of my current job
            if (currJob.deadline > Time) {  // still I've time to complete this job
                maxProfit += currJob.profit;
                selectedJob.add(currJob.idx);        // adding idx of selected job
                Time++;
            }
        }

        int ans[] = new int[2];
        ans[0] = selectedJob.size(); // no of job can be done
        ans[1] = maxProfit;         // maxprofit
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] );
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int jobs[][] = {{4,20},{1,10},{1,40},{1,30}};
        maxProfit(jobs);
    }
}
