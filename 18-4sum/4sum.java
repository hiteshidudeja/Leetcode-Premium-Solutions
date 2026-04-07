class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                long sum = nums[i] + nums[j];
                int k = j + 1; int l = n -1;
                while(k < l){
                    if(sum + nums[k] + nums[l] == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        while(k < l && k < n && nums[k - 1] == nums[k]) k++;

                    } else if(sum + nums[k] + nums[l] < target) k++;
                    else l--;
                }
            }
        }


        return list;
    }
}