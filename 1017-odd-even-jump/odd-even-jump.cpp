class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        int n = arr.size();
        map<int, int>seen;

        vector<int>oddJumpIndices(n, n); // a[j] >= a[i]
        vector<int>evenJumpIndices(n, n); // a[j] <= a[i];

        for(int i = n - 1; i >= 0; i--){
            if(!seen.empty()){
                auto it = seen.lower_bound(arr[i]);
                if(it!= seen.end() && it->first == arr[i]) {
                    evenJumpIndices[i] = it->second;
                    oddJumpIndices[i] = it->second;
                }
                else {
                    if(it != seen.begin()) evenJumpIndices[i] = prev(it)->second;
                    if(it != seen.end()) oddJumpIndices[i] = it->second;
                }
            }

            seen[arr[i]] = i;           
        }

        vector<vector<bool>>dp(n, vector<bool>(2, false));
        dp[n - 1][0] = true; dp[n - 1][1] = true;
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                // evenJump
                if(j % 2 == 0){
                    if(evenJumpIndices[i] == n) dp[i][j] = false;
                    else dp[i][j] = dp[evenJumpIndices[i]][1 - j];
                } else {
                    if(oddJumpIndices[i] == n) dp[i][j] = false;
                    else dp[i][j] = dp[oddJumpIndices[i]][1 - j];
                }
            }
        }

        int result  = 0;

        for(int i = 0; i < n; i++){
            if(dp[i][1]) result++;
        }

        return result;

    }
};