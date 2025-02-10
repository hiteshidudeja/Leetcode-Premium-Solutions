class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        unordered_map<int, int>count;

        int subArrays = 0; int prefixSum = 0;
        count[0] = 1;
        for(int i = 0; i < nums.size(); i++){
            prefixSum += nums[i];
            int temp = (prefixSum % k + k) % k;
            cout<<temp<<"\n";
            subArrays += count[temp];
            count[temp]++;
        }

        return subArrays;
    }
};