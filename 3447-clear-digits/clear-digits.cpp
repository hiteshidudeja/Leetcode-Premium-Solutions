class Solution {
public:
    string clearDigits(string s) {
        stack<char>st;
        for(char c : s){
            if(c - '0' >= 0 && c - '0' <= 9){
                if(!st.empty()) st.pop();
            }else st.push(c);
        }

        string result = "";
        while(!st.empty()) {
            result += st.top();
            st.pop();
        }

        reverse(result.begin(), result.end());
        return result;

    }
};