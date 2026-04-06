class Solution {

    private int binarySearch(int i, int[] nums, int target){
        int lo = i; int hi = nums.length - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < target) lo = mid + 1;
            else if(nums[mid] > target) hi = mid - 1;
            else if(nums[mid] == target) return mid;
        }

        return -1;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // hashmap
        // binary search
        // n**2 log n 
        
        Arrays.sort(nums); int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int target = (nums[i] + nums[j]) * -1;
                if(j < n - 1) {
                    int idx = binarySearch(j + 1, nums, target);
                    if (idx != -1){
                            ans.add(Arrays.asList(nums[i], nums[j], nums[idx]));
                    }
                }
            }
        }

        return ans;

    }
}