class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int half = sum / 2; if(sum % 2 != 0) return false;
        vector<vector<bool>>dp(n + 1, vector<bool>(half + 1, false));


        for(int i = 0; i <= half; i++){
            dp[0][i] = false;
        }

        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= half; j++){
                if(j >= nums[i - 1])
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                dp[i][j] = dp[i][j] || dp[i - 1][j];
            }
        }

        return dp[n][half];
    }
};