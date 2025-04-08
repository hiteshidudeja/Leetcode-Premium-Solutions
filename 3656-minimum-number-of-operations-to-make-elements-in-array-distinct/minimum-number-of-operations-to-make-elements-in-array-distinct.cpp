class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        vector<int>frequency(101, 0);
        for(int i = nums.size() - 1; i >= 0; i--){
            frequency[nums[i]]++; 
            if(frequency[nums[i]] > 1) return (i / 3) + 1;
        }

        return 0;
    }
};