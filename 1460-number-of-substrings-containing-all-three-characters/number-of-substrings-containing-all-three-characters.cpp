class Solution {
public:
    int numberOfSubstrings(string s) {
        int n = s.length();
        // count of a, b, c
        vector<int>count(3, 0);

        int total = 0; int i = 0;
        for(int j = 0; j < n; j++){
            count[s[j] - 'a']++;
            while(count[0] >= 1 && count[1] >= 1 && count[2] >= 1){
                total += n - j;
                count[s[i] - 'a']--; i++;
            }
        }

        return total;
    }
};