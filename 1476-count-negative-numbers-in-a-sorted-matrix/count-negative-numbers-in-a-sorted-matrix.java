class Solution {
    public int lowerBound(int[] nums){
        int n = nums.length; int lo = 0; int hi = n - 1;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] >= 0){
                ans = mid;
                lo = mid + 1;
            } else if(nums[mid] < 0){
                hi = mid - 1;
            } 
        }

        return ans;
    }
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; int count = 0;

        for(int i = 0; i < n; ++i){
            int index = lowerBound(grid[i]);
            if(index == -1) count += m;
            else count += m - index - 1 ;
        }

        return count;
    }
}