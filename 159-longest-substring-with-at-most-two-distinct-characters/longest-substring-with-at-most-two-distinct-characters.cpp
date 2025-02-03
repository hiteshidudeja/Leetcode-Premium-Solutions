class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        int n = s.length(); int j = 0;
        vector<int>frequency(256, 0);

        // 'a - z' , 'A - Z'

        int length = 0; int count = 0;
        for(int i = 0; i < n; i++){
            frequency[s[i]]++; if(frequency[s[i]] == 1) count++;
            while(count > 2){
                frequency[s[j]]--;
                if(frequency[s[j]] == 0) count--;
                j++;
            }

            length = max(length, i - j + 1);
        }

        return length;
    }
};