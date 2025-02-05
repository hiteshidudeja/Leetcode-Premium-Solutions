class Solution {
public:
    int maxDistance(string s, int k) {
        unordered_map<char, int>map;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            map[s[i]]++;
            int moves = min(i + 1, abs(map['N'] - map['S']) + abs(map['E'] - map['W']) + 2 * k);

            ans = max(ans, moves);
        }

        return ans;
    }
};