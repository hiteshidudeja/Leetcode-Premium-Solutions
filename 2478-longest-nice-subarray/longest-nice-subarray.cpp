class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        int i = 0; int n = nums.size();
        int used = 0;
        int res = 0;
        for(int j = 0; j < n; j++){
            while((used & nums[j]) !=0){
                used ^= nums[i]; i++;
            }

            used |= nums[j];
            res = max(res, j - i + 1);


        }

        return res;
    }
};