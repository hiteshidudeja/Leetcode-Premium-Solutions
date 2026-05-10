class Solution {
    public int maximumJumps(int[] nums, int target) {
        // try all possible ways 
        // dp[i] = max jumps to reach to ith position
        // 
        // dp[j] = dp[j] + dp[i] + 1  (-target <= nums[j] - nums[i] <= target)

        int n = nums.length;
        int[] dp = new int[n]; Arrays.fill(dp, -1); dp[0] = 0;

        for(int j = 1; j < n; j++){
            for(int i = 0; i < j; i++){
                if(dp[i] != -1 && Math.abs(nums[i] - nums[j]) <= Math.abs(target)){
                    dp[j] = Math.max(dp[j] , dp[i] + 1);
                }
            }
        }

        return dp[n - 1];


    }
}