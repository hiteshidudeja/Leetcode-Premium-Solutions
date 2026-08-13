class Solution {
    public int singleNonDuplicate(int[] nums) {
        // nums[mid] == nums[mid - 1] {
        // check if mid is even (right = mid - 1) else if left = mid - 1
       // nums[mid] == nums[mid + 1] -> check if mid + 1 is even (right = mid - 1) else left = mid - 1
       // else return mid

       int n = nums.length;

       int left = 0; int right = n - 1;

       while(left <= right){
            int mid = left + (right - left)/2;

            if(mid + 1 < n && nums[mid] == nums[mid + 1]) {
                if((mid + 1) % 2 == 1) left = mid + 1;
                else right = mid - 1;

            } else if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                if(mid % 2 == 1) left = mid + 1;
                else right = mid - 1;
            } else return nums[mid];
       }

       return left;
    }
}