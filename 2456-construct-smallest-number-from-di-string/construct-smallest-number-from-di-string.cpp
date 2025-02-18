class Solution {
public:
    string smallestNumber(string pattern) {
        pattern = "I" + pattern;
        int n = pattern.length();

        string result = ""; int s = 1; int i;
        for(i = 0; i < n - 1; i++){
            if(pattern[i] == 'I' && pattern[i + 1] == 'D'){
                int temp = i + 1; int count = 0;
                while(temp < n && pattern[temp] == 'D') {
                    count++; temp++;
                }
                s += count; int t = s - 1;
                result += s + '0';
                while(count--){
                    result += t + '0'; i++;
                    t--;
                }
            } else {
                result += s + '0';
            }

            s++;
        }

        if(i == n - 1){
            result += s + '0';
        }

        return result;
    }
};