class Solution {
public:
    bool checkValidString(string s) {
        int n = s.length();

        int open = 0; int closed = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '(' || s[i] == '*') open++;
            else open--;

            if(s[n - i - 1] == ')' || s[n - i - 1] == '*') closed++;
            else closed--;

            if(open < 0 || closed < 0) return false;
        }


        return true;
    }
};