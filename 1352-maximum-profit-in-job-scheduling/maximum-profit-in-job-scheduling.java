class Solution {
    private static class Job{
        int startTime; int endTime; int profit;

        public Job(int startTime, int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    private int upperBound(Job[] jobs, int endIndex, int targetTime){
        int lo = 0; int hi = endIndex;

        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(jobs[mid].endTime <= targetTime){
                lo = mid + 1;
            } else hi = mid;
        }

        return lo;
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // max profit?
        int n = profit.length;
        Job[] jobs = new Job[n];

        for(int i = 0; i < n; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

        int[] dp = new int[n + 1];

        for(int i = 0; i < n; i++){
            int startTimeVal = jobs[i].startTime; int endTimeVal = jobs[i].endTime; int profitVal = jobs[i].profit;
            int idx = upperBound(jobs, i, startTimeVal);

            dp[i + 1] = Math.max(dp[i], dp[idx] + profitVal);
        }

        return dp[n];




        
    }
}