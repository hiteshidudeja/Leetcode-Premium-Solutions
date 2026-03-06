class Solution {
    public int maxSubArray(int[] nums) {
        // max sum
        // curr sum
        // if (curr sum < 0) curr sum = 0

        int n = nums.length;
        int maxSum = Integer.MIN_VALUE; int currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);
            if(currSum < 0) currSum = 0;
        }

        return maxSum;
    }
}