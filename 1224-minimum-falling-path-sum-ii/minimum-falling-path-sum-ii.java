class Solution {
    public int minFallingPathSum(int[][] grid) {
        //dp[i][j] = min sum obtained from 0 -> ith rows when the col is j 
        // dp[i][j] = grid[i][j] + min(dp[i-1][0], .........dp[i-1][j - 1], dp[i-1][j + 1]....)
        int n = grid.length;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int minVal = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(k == j) continue;
                    minVal = Math.min(minVal, grid[i - 1][k]);
                }

                grid[i][j] += minVal;
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) ans = Math.min(ans, grid[n-1][i]);

        return ans;
    }
}