class Solution {
public:
    string clearDigits(string s) {
        string result = "";
        for(char c : s){
            if(c - '0' >= 0 && c - '0' <= 9){
                if(result.size() > 0) result.pop_back();
            }else result.push_back(c);
        }

        return result;

    }
};