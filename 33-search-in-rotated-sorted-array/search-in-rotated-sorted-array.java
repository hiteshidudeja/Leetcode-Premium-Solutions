class Solution {
    public int search(int[] nums, int target) {
        // mid, target, (hi)
        // nums[mid] < target && nums[hi] < target lo = mid + 1 (left range)
        // nums[mid] < target && nums[hi] > target lo = mid + 1
        // nums[mid] > target && nums[hi] < target hi = mid - 1
        // nums[mid] > target && nums[hi] >= target lo = mid + 1;
        // mid == target ()
        // 0, 6, 3
        // 1, 6, 3
        int n = nums.length; int lo = 0; int hi = n - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return mid;
            // mid in first sorted half
            if(nums[lo] <= nums[mid]){
                if(target < nums[mid] && nums[lo] <= target){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[hi]){
                    lo = mid + 1; 
                } else hi = mid - 1;
            }
        }


        return -1;

    }
}