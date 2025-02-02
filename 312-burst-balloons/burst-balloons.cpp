class Solution {
public:
    int maxCoins(vector<int>& nums) {
        // 3 1 5 8 

        int n = nums.size(); int m = n + 2;
        vector<int>temp(m);
        temp[0] = 1; temp[m - 1] = 1;
        for(int i = 1; i < m - 1; i++)
            temp[i] = nums[i - 1];

        vector<vector<int>>dp(m, vector<int>(m, INT_MIN));

        for(int i = 0; i < m; i++) dp[i][i] = 0;

        for(int L = 2; L < m; L++){
            for(int i = 1; i < m - L + 1; i++){
                int j = i + L - 1;
                for(int k = i; k <= j - 1; k++){
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k + 1][j] + temp[i - 1] * temp[k] * temp[j]);
                }
            }
        }

        return dp[1][m-1];
         
    }
};