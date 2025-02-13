class Solution {
public:
    string smallestBeautifulString(string s, int k) {
        s = "01" + s;
        int n = s.length();

        char mxC = 'a' + k;


        for(int i = n - 1; i > 1; --i){
            //{i-2, i-1, i}

            char a[3] = {s[i-2], s[i-1], s[i]};
            for(char c = s[i] + 1; c < mxC; ++c){
                bool pos = false;
                for(int j = 0; j < 2; ++j){
                    pos |= a[j] == c;
                }
                if(pos) continue;
                
                s[i] = c;
                i++;
                for(; i < n; ++i){
                    char a[3] = {s[i-2], s[i-1], s[i]};
                    for(char c = 'a'; c < mxC; ++c){
                        pos = false;
                        for(int j = 0; j < 2; ++j){
                            pos |= a[j] == c;
                        }
                        if(pos) continue;
                        s[i] = c;
                        break;
                    }
                }


                return s.substr(2);
            }
        }




        return "";

        // int i = n - 1;
        // while(i >= 0){
        //     if((s[i] - 'a' + 1) % k ==  s[n - 1 - i] - 'a'){
        //         int temp = (s[i] - 'a' + 2) % k;
        //         s[i] = temp + 'a'
        //     }
            
        // }
    }
};