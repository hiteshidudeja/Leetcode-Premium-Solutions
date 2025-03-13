class Solution {
public:
    int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        // binary search on ans
        int lo = 0; int hi = queries.size();

        auto possible = [&](int k){
            vector<int>sweepLine(1e5 + 1, 0);
            for(int i = 0; i < k; i++){
                int l = queries[i][0]; int h = queries[i][1]; 
                sweepLine[l]+=queries[i][2]; sweepLine[h + 1]-=queries[i][2];
            }

            int curr = 0;

            for(int i = 0; i < nums.size(); i++){
                curr += sweepLine[i];
                if(curr < nums[i]) return false;
            }

            return true;
        };

        int ans = -1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(possible(mid)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
};