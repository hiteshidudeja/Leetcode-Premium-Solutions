class Solution {
public:
    int lengthOfLongestSubsequence(vector<int>& nums, int target) {
        // length(LS) - 6 +  length(LS) - 3

        // maximum number of elements in array which sum to x
        vector<int>dp(target + 1, INT_MIN); dp[0] = 0;

        for(auto &num : nums){
            for(int i = target; i >= num; i--){
                if(dp[i - num] != INT_MIN)
                    dp[i] = max(dp[i], dp[i - num] + 1);
            }
        }

        return dp[target] == INT_MIN ? -1 : dp[target];
    }
};