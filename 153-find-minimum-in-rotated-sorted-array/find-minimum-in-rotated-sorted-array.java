class Solution {
    public int findMin(int[] nums) {
        // binary search 
        int lo = 0; int n = nums.length; int hi = n - 1; 

        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }

        return nums[lo];
    }
}