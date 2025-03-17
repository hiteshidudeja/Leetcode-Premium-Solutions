class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        // 2 3 5 9 
        // ans - [x, x + 1]

        int n = nums.size();
        int lo = *min_element(nums.begin(), nums.end());
        int hi = *max_element(nums.begin(), nums.end());

        auto possible = [&](int capability){
            int houses = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] <= capability){
                    houses++; i++;
                }
            }

            return houses >= k;
        };
        int ans = -1;
        while(lo <= hi){
            int mid = (lo + hi)/ 2;
            if(possible(mid)){
                ans = mid; hi = mid - 1;
            } else lo = mid + 1;
        }

        return ans;
    
    }
}; 