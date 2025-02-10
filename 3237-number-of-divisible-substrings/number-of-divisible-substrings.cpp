class Solution {
public:
    int countDivisibleSubstrings(string word) {
        int n = word.length();
        vector<int>prefixSum(n + 1, 0);
        vector<int>charMap(26, 0);
        charMap[0] = 1; charMap[1] = 1;
        int f = 0; int num = 2;
        for(int i = 2; i < 26; i++){
            if(f == 3){
                f = 0;
                num++;
            }
            charMap[i] = num;
            f++;
        }

        prefixSum[0] = 0;
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + charMap[word[i] - 'a'];
        }

        int result = 0;

        for(int i = 0; i<= n; i++){
            for(int j = i + 1; j <= n; j++){
                if((prefixSum[j] - prefixSum[i]) %(j - i) == 0)
                    result++;
            }
        }

        return result;
    }
};