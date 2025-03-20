class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        const int inf = 1e9;
        vector<int> dp(amount + 1, inf);
        dp[0] = 0;
        for(auto &c : coins){
            for(int i = 0; i <= amount - c; ++i){
                dp[i + c] = min(dp[i + c], dp[i] + 1);
            }
        }
        return dp[amount] < inf ? dp[amount] : -1;
    }
};