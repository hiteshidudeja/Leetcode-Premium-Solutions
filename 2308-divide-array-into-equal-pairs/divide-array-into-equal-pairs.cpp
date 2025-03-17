class Solution {
public:
    bool divideArray(vector<int>& nums) {
        int a[501] = {0};
        int n = nums.size();
        if(n % 2 != 0) return false;
        for(int i = 0; i < n; i++){
            a[nums[i]]++;
        }

        for(int i = 0; i < 501; i++){
            if(a[i] % 2 != 0) return false;
        }

        return true;
    }
};