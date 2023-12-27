public class minTime {
    public static int minCost(String colors, int[] neededTime) {
        int minTime = 0; // initially time & prevMax is 0;
        int prevMax = 0; 
        for (int i = 0; i < colors.length(); i++) {
            
            // if both balloons  are different we don't have to remove any ballon
            if(i> 0 && colors.charAt(i) != colors.charAt(i-1)){     // i>0 is for first index
                prevMax = 0;        // reset previous max as zero
            }

            // each time we will update min time & prev max
            int currTime = neededTime[i];
            minTime += Math.min(prevMax, currTime);     // remove balloons who has min time
            prevMax = Math.max(prevMax, currTime);  // set maximum value as prevMax for the next comparison
        }
        return minTime;
    }
    public static void main(String[] args) {
        String colors = "aaabbbabbbb";
        int neededTime[] = {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(minCost(colors, neededTime));
    }
}
