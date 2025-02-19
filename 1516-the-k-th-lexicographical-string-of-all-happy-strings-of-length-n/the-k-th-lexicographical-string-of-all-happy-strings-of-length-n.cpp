class Solution {
private:
    void generate(int n, vector<string>&possibilities, string s){
        if(s.length() == n){
            possibilities.push_back(s); return;
        }

    
        for(char c = 'a'; c <= 'c'; c++){
            if(!s.empty() && c == s.back()) continue;
            generate(n, possibilities, s + c);
        }

    }
public:
    string getHappyString(int n, int k) {
        vector<string>possibilities; string s = "";

        generate(n, possibilities, s);
        if(possibilities.size() < k) return "";
        return possibilities[k - 1];
    }
};