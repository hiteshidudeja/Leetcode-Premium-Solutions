class Solution {
    public boolean stoneGame(int[] piles) {
        // 5 3 4 5
        int n = piles.length;
        int[][] dp = new int[n][n];

        // dp[i][j] = max stones which alice can have give piles piles[i, j]
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(i == j) dp[i][j] = piles[i];
                else if(i > j) dp[i][j] = 0;
            }           
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i < j){
                    dp[i][j] = Math.max(piles[i] + dp[i + 1][j], piles[j] + dp[i][j - 1]);
                }
            }
        }

        int sum = Arrays.stream(piles).sum();

        return dp[0][n - 1] > sum - dp[0][n - 1];
    }
}