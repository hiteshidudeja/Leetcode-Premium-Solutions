class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long long, vector<long long>, greater<long long>>pq;
        for(int num : nums){
            pq.push(num);
        }

        int ops = 0;

        while(pq.size() >=2 && pq.top() < k) {
            long long a = pq.top(); pq.pop();
            long long b = pq.top(); pq.pop();
            pq.push(2 * min(a, b) + max(a , b));
            ops++;
        }

        return ops;
    }
};