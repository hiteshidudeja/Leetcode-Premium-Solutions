class Solution {

public:
    // static bool comp(pair<int, int>a, pair<int, int>b){
    //     return a.first < b.first;
    // }
    int maxSubarrayLength(vector<int>& nums) {
        int n = nums.size();
        vector<pair<int, int>>indexElement(n);
        for(int i = 0; i < n; i++){
            indexElement[i] = { nums[i], i};
        }

        sort(indexElement.begin(), indexElement.end());

        int pos = -1;
        int ans = INT_MIN;

        for(int i = 0; i< n; i++){
            // cout<<indexElement[i].second<<" ";
            ans = max(ans, pos - indexElement[i].second + 1);
            pos = max(pos, indexElement[i].second);

        }

        return ans;


    }   
};