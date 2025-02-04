class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        int n = nums.size();
        int sum = nums[0]; int result = INT_MIN;
        for(int i = 1; i < n ; i++){
            if(nums[i] <= nums[i - 1]) {
                result = max(result, sum); sum = 0;
            }
            sum += nums[i];
        }

        result = max(result, sum);

        return result;
    }
};