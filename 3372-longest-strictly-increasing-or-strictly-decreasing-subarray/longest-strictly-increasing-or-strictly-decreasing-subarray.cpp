class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int result = 1;

        int n = nums.size();

        // increasing
        int j = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] <= nums[i - 1])
                j = i;
            result = max(result, i - j + 1);
        }

        j = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] >= nums[i - 1])
                j = i;
            
            result = max(result, i - j + 1);
        }

        return result;
    }
};