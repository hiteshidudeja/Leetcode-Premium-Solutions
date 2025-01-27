class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        // for each element i find an element j in the right such that a[j] < a[i] && abs(j-i) <= 2
        // 1 5 3 9 8  -> 1 3 5 8 9 & (limit = 2)
        // 1 3 5 8 9 

        int n = nums.size();
        vector<pair<int, int>>b;
        for(int i = 0; i < n; i++){
            b.push_back({nums[i], i});
        }

        sort(b.begin(), b.end());
        // sorted array

        vector<vector<pair<int, int>>>v = {{b[0]}};

        for(int i = 1; i < n; i++){
            if(abs(b[i].first - b[i-1].first) <= limit){
                v.back().push_back(b[i]);
            }
            else v.push_back({b[i]});
        }

        for(auto arr: v){
            vector<int>indices;
            for(auto pr: arr) {
                // cout<<pr.first<<" "<<pr.second<<" ";
                indices.push_back(pr.second);
            }
            // cout<<"\n";
            sort(indices.begin(), indices.end());

            for(int i = 0; i < arr.size(); i++){
                nums[indices[i]] = arr[i].first;
            }
        }


        return nums;


    }
};