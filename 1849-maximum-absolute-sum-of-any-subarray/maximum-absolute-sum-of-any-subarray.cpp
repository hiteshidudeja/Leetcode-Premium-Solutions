class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        // 1 -2 0 3 -1
        // 2 -3 -2 -6 -3 -5
        // 1 3 6 
        
        int maxPrefix = 0;
        int minPrefix = 0;

        int prev = 0;
        for(int i = 0; i < nums.size(); i++){
            int temp = nums[i] + prev;
            prev = temp;
            maxPrefix = max(maxPrefix, temp);
            minPrefix = min(minPrefix, temp);
        }

        return abs(maxPrefix - minPrefix);
    }
};