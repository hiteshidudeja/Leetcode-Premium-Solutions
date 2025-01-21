class Solution {
public:
    int maxSubarrayLength(vector<int>& nums) {
        int n = nums.size();
        stack<int>s;
        for(int i = 0; i < n; i++){
            if(s.empty() || nums[i] > nums[s.top()])
                s.push(i);
        }

        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            while(!s.empty() && nums[s.top()] > nums[i]) {
                ans = max(ans, i - s.top() + 1);
                s.pop();
            }
        }

        return ans;
    }
};