class Solution {
    public int longestOnes(int[] nums, int k) {
        // slidinh window 

        int temp = 0; int length = 0; int i = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 0) {
                temp++;
            }

            if(temp > k){
                if(nums[i] == 0) temp--;
                i++;
            }

            length = Math.max(length, j - i + 1);



        }

        return length;
    }
}