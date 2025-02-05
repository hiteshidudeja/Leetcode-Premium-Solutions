class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        vector<int>frequency(101, 0); int count = 0;
        for(int i = 0; i < nums.size(); i++){
            frequency[nums[i]]++;
            if(nums[i] > 0 && frequency[nums[i]] == 1) count++;
        }

        return count;
    }
};