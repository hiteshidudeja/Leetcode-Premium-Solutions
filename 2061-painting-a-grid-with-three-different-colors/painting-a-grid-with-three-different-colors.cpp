class Solution {
public:
    int mod = 1e9 + 7;
    int dp[1001][250], rowValid[250][250];
    vector<int>good, pattern[250];
    int colorTheGrid(int m, int n) {
        // dp[i][j] = dp[i - 1][j] dp[i][j - 1]
        // bitmask

        // total number of masks
        int total = pow(3, m);

        // patterns possible 
        // good patterns
        for(int i = 0; i < total; i++){
            int val = i; bool valid = true;
            for(int j = 0; j < m; j++){
                pattern[i].push_back(val % 3); val = val/3;
            }

            for(int j = 0; j < m - 1; j++){
                if(pattern[i][j] == pattern[i][j + 1]) valid = false;
            }

            if(valid) good.push_back(i);
        }

        for(int i: good) dp[1][i] = 1;

        for(int i : good){
            for(int j : good){
                rowValid[i][j] = 1;
                for(int k = 0; k < m; k++){
                    if(pattern[i][k] == pattern[j][k]) rowValid[i][j] = 0;
                }
            }
        }

        for(int i = 2; i <= n; i++){
            for(int j : good){
                for(int k : good){
                    if(rowValid[j][k]) dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                }
            }
        }

        return accumulate(dp[n], dp[n] + total, 0L) % mod;



    }
};