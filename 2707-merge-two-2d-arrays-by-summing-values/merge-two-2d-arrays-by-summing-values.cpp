class Solution {
public:
    vector<vector<int>> mergeArrays(vector<vector<int>>& nums1, vector<vector<int>>& nums2) {
        map<int, int>mp;
        for(auto &num1 : nums1){
            int id = num1[0]; int val = num1[1];
            if(mp.find(id) == mp.end()) mp[id] = val;
            else mp[id]+=val;
        }

        for(auto &num2 : nums2){
            int id = num2[0]; int val = num2[1];
            if(mp.find(id) == mp.end()) mp[id] = val;
            else mp[id]+=val;
        }

        vector<vector<int>>result;

        for(auto &entry : mp){
            result.push_back({entry.first, entry.second});
        }

        return result;
    }
};