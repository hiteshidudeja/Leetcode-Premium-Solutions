class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;  
        int currSum = 0; int maxSum = Integer.MIN_VALUE;
        int start = 0; int ansStart = 0; int ansEnd = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i]; 
            if(currSum > maxSum){
                maxSum = currSum;
                ansStart = start; ansEnd = i;
            }
            
            if(currSum < 0) {
                currSum = 0; start = i + 1;
            }
        }

        System.out.println(ansStart + " to " + ansEnd);
        return maxSum;
    }
}