class Solution {
public:
    string shortestCommonSupersequence(string str1, string str2) {
        // str1 and str2 
        // abac // cab
        int n = str1.length(); int m = str2.length();
        vector<vector<int>>dp(n + 1, vector<int>(m + 1, 0));
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int i = 0; i <= m; i++){
            dp[0][i] = 0;
        }

        // LCS

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1[i - 1] == str2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        

        string lcs = "";
        
        int i = n; int j = m;

        while(i >= 1 && j >= 1){
            if(str1[i - 1] == str2[j - 1]){
                lcs += str1[i - 1]; i--; j--;
            } else if(dp[i][j] == dp[i - 1][j]){
                lcs += str1[i - 1];
                i--;
            } else if(dp[i][j] == dp[i][j - 1]){
                lcs += str2[j - 1];
                j--;
            }
        }
        while(i >= 1){
            lcs += str1[i - 1]; i--;
        }

        while(j >= 1){
            lcs += str2[j - 1]; j--;
        }

        reverse(lcs.begin(), lcs.end());

        return lcs;



    }
};