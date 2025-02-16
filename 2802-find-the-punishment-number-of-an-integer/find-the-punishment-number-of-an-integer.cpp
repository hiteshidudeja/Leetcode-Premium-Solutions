// x1 x2 x3 x4 x5 x6 |
// 7C1 + 8C2 + 9C3 + 10C4 + 11C5 == 

class Solution {
public:

    int punishmentNumber(int n) {
 
        int ans = 0;
 
        for(int x = 1; x <= n; ++x){
            int sq = x*x;
            string s = to_string(sq);

            auto possible = [&](auto &self, int index, int sum) -> bool{
                if(index == s.size()) return sum == x;

                for(int i = index + 1; i <= s.size(); ++i){
                    // [index, i)

                    if(self(self, i, sum + stoi(s.substr(index, i - index)))){
                        return true;
                    }

                }

                return false;
            };

            if(possible(possible, 0, 0)) ans += sq;
        }

        return ans;


    }
};