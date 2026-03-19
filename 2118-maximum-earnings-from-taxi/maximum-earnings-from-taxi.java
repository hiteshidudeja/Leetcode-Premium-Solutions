class Solution {
    private static class Ride{
        private int start; private int end; private int tip;

        public Ride(int start, int end, int tip){
            this.start = start; this.end = end; this.tip = tip;
        }
    }

    private int upperBound(Ride[] rides, int idx, int startTime){
        int lo = 0; int hi = idx;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(rides[mid].end <= startTime) lo = mid + 1; else hi = mid;
        }

        return lo;
    }


    public long maxTaxiEarnings(int N, int[][] rides) {
        int n = rides.length;
        Ride[] rideS = new Ride[n];

        for(int i = 0; i < n; i++){
            rideS[i] = new Ride(rides[i][0], rides[i][1], rides[i][2]);
        }
        

        // 
        Arrays.sort(rideS, Comparator.comparingInt(ride -> ride.end));

        long[] dp = new long[n + 1];

        for(int i = 0; i < n; i++){
            int start = rideS[i].start; int tip = rideS[i].tip; int end = rideS[i].end;
            int idx = upperBound(rideS, i, start);
            dp[i + 1] = Math.max(dp[i], end - start + tip + dp[idx]);
        }

        return dp[n];


    }
}