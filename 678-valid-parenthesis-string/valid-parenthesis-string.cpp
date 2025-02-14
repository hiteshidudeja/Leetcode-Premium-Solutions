class Solution {
public:
    bool checkValidString(string s) {
        int leftParenthesis = 0; int special = 0;
        int n = s.size();
        if(n == 1) {
            if(s[0] == '*') return true;
            return false;
        }
        for(int i = 0; i < n; i++){
            if(s[i] == '(') leftParenthesis++;
            else if(s[i] == '*') special++;
            else if(s[i] == ')'){
                if(leftParenthesis > 0) leftParenthesis--;
                else if(special > 0) special--;
                else return false;
            }
        }

        int closedParenthesis = 0; special = 0;

        for(int i = n - 1; i >= 0; i--){
            if(s[i] == ')') closedParenthesis++;
            else if(s[i] == '*') special++;
            else if(s[i] == '('){
                if(closedParenthesis > 0) closedParenthesis--;
                else if(special > 0) special--;
                else return false;
            }
        }


        return true;
    }
};