class Solution {
    int[][][] dp;
    public int solve(int i, int Case, int k, int[] prices){
        // base 
        if(i == prices.length){
            return 0;
        }
        if(dp[i][Case][k] != Integer.MIN_VALUE) return dp[i][Case][k];
        int notTake = solve(i + 1, Case, k, prices);
        int take = Integer.MIN_VALUE;
        if(k > 0){
            if(Case == 0) {
                take = -prices[i] + solve(i + 1, 1, k, prices);
            } else if(Case == 1){
                take = prices[i] + solve(i + 1, 0, k - 1, prices);
            }
        }

        return dp[i][Case][k]= Math.max(take, notTake);
    }
    public int maxProfit(int[] prices) {
        // Case = 0 - fresh transaction
        // Case = 1 - bought previously 
        dp = new int[prices.length][2][2];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++) dp[i][j][k] = Integer.MIN_VALUE;
            }
        }
        return solve(0, 0, 1, prices);

    }
}