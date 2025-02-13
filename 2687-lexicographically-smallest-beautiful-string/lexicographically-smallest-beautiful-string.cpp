class Solution {
public:
    string smallestBeautifulString(string s, int k) {
        s = "01" + s;
        int n = s.length();

        char mxC = 'a' + k;


        for(int i = n - 1; i > 1; --i){
            //{i-2, i-1, i}

            for(char c = s[i] + 1; c < mxC; ++c){
                if(s[i-1] == c || s[i - 2] == c) continue;
                
                s[i] = c;
                for(++i; i < n; ++i){
                    for(char c = 'a'; c < mxC; ++c){
                        if(s[i-1] == c || s[i-2] == c) continue;
                        s[i] = c;
                        break;
                    }
                }

                return s.substr(2);
            }
        }




        return "";
    }
};