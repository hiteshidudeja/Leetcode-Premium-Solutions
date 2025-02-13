class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        int n = s.length(); 
        unordered_map<char, int>frequency;
        int i = 0; int result = INT_MIN;
        for(int j = 0; j < n; j++){
            frequency[s[j]]++;
            while(i < j && frequency[s[j]] > 1){
                frequency[s[i]]--;
                i++;
            }
            result = max(result, j - i + 1);
        }

        return result == INT_MIN ? 0 : result;
    }
};