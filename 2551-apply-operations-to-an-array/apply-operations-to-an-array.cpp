class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        int n = nums.size();  
        for(int j = 0; j < n - 1; j++){
            if(nums[j] == nums[j + 1]){
                nums[j] = 2 * nums[j]; nums[j + 1] = 0;
            } 
        }




        vector<int>result; int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0) result.push_back(nums[i]);
            else count++;
        }

        for(int i = 0; i < count; i++){
            result.push_back(0);
        }

        return result;
    }
};