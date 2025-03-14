class Solution {
public:
    vector<long long> findMaxSum(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        vector<pair<int, int>>idx(n);
        for(int i = 0; i < n; i++){
            idx[i] = {nums1[i], i};
        }

        sort(idx.begin(), idx.end());

        vector<long long>result(n);
        priority_queue<int, vector<int>, greater<int>>pq;
        long long sum = 0; int j = 0;
        for(int i = 0; i < n; i++){
            int ind = idx[i].second; int curr = idx[i].first;
            while(j < i){
                int prev = idx[j].first; int prevInd = idx[j].second;
                if(prev == curr) break;
                pq.push(nums2[prevInd]);
                sum += nums2[prevInd];
                if(pq.size() > k){
                    sum -= pq.top(); pq.pop();
                }

                j++;
            }
            result[ind] = sum;
        }

        return result;
    }
};