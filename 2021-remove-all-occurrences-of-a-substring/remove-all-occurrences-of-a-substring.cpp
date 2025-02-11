class Solution {
public:
    string removeOccurrences(string s, string part) {
        int n = s.length();
        int m = part.length();
        while(s.find(part)!= string::npos){
            int idx = s.find(part);
            s.erase(idx, m);
        }

        return s;
    }
};