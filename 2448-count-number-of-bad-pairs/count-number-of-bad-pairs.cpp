class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int>count;
        // 4 0 1 0 (6 - 1 = 5)

        long long goodPairs = 0;
        for(int i = 0; i < n; i++){
            int diff = nums[i] - i;
            goodPairs += count[diff];
            count[diff]++;
        }

        return (1LL * n * (n - 1)) / 2 - goodPairs;

    
    }
};