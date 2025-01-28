class Solution {
public:
    long long minimumOperations(vector<int>& nums, vector<int>& target) {
        // 3 5 1 2 -> 4 6 2 4 ( 1, 1, 1, 2)
        // 1 2 3 4 -> 2 4 5 8 ( 1 2 2 4)
        // +1 // -1 
        // 1 3 2 -> 2 1 4  ( +1  -2  +2) -> min operations 
        // 5 -2 2
        //  5 -2 -1 6 -8 0 1 4 

        int n = nums.size();

        vector<int>res; 
        for(int i = 0; i < n; i++) res.push_back(target[i] - nums[i]);

        int prev = 0; long long ops = 0;

        for(int i = 0; i < n; i++){
            if((res[i] > 0 && prev < 0) || (res[i] < 0 && prev > 0))
                ops += abs(res[i]);
            else if(abs(res[i]) - abs(prev) > 0)
                ops += abs(res[i]) - abs(prev);
            
            prev= res[i];
        }

        return ops;
        
    }
};