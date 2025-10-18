class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        // [-1, 3]
        // [0, 4]
        // [0, 4]
        // [1, 5]
        // [2, 6]

        // [3, 5]
        //[3, 5]
        //[3, 5]
        // [3, 5]

        Arrays.sort(nums);
        int prev = nums[0] - k; int count = 1;

        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(Math.max(prev + 1, nums[i] - k) <= nums[i] + k){
                count++;
                prev = Math.max(prev + 1, nums[i] - k);
            }
        }

        return count;

    }
}