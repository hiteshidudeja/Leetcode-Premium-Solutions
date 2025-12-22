class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; int result = Integer.MIN_VALUE;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int j = 0; j < n; j++){
            for(int i = 0; i < j; i++){
                if(nums[i] < nums[j]){
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
            result = Math.max(result, dp[j]);
        }

        return result;
    }
}