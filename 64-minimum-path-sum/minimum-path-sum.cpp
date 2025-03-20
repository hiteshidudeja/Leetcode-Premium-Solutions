class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size(); int m = grid[0].size();
        vector<vector<int>>dp(n, vector<int>(m));

        int prev = 0;
        for(int i = 0; i < n; i++){
            dp[i][0] = grid[i][0] + prev;
            prev = dp[i][0];
        }

        prev = 0;
        for(int i = 0; i < m; i++){
            dp[0][i] = grid[0][i] + prev; prev = dp[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }
};