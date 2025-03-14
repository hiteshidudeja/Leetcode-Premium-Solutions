class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        // binary search
        int lo = 1; int hi = *max_element(candies.begin(), candies.end());

        int ans = 0;

        auto possible = [&](int m){
            long long kids = 0;
            for(int candy: candies){
                kids += candy / m;
            }

            return kids >= k;
        };

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(possible(mid)){
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
};