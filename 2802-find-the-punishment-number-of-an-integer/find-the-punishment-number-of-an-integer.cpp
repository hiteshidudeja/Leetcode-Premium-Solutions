class Solution {
private:
    bool possible(int index, int sum, string square, int x){
        if(index == square.size()) return sum == x;
        for(int i = index + 1; i <= square.size(); i++){
            if(possible(i, sum + stoi(square.substr(index, i - index)), square, x)) return true ;
        }

        return false;
    }
public:
    int punishmentNumber(int n) {
        int ans = 0;

        for(int i = 1; i <= n; i++){
            int square = i * i;
            if(possible(0, 0, to_string(square), i)) ans += square;
        }

        return ans;
    }
};