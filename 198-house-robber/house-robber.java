class Solution {
    public int rob(int[] nums) {
        // dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1])
        //dp[i] = max amount of money which can be robbed when there are first i houses
        int n = nums.length; int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = nums[0];

        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i -1]);
        }

        return dp[n];
    }
}