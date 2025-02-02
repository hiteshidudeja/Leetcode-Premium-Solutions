class Solution {
public:
    vector<int> distinctNumbers(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int>frequency(1e5 + 1, 0);
        vector<int>result;
        for(int i = 0; i < k; i++){
            frequency[nums[i]]++;
        }

        int count = 0;

        for(auto freq : frequency){
            if(freq > 0)  count++;
        }

        result.push_back(count);

        int j = k; int i = 0;

        while(j < n){
            frequency[nums[i]]--; 
            if(frequency[nums[i]] == 0) count-=1;
            frequency[nums[j]]++;
            if(frequency[nums[j]] == 1) count += 1;
            i++;  j++;
            result.push_back(count);
        }

        return result;

    }
};