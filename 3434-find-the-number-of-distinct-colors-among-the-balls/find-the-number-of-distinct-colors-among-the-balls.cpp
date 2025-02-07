class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        // [[1 4][2 5][1 3][3 4]]

        vector<int>result;

        unordered_map<int, int>ballToColor;
        unordered_map<int, int>colorToBalls;

        for(auto query: queries){
            int ball = query[0]; int color = query[1];
            if(ballToColor.find(ball) != ballToColor.end()){
                int prevColor = ballToColor[ball];
                colorToBalls[prevColor]--;
                if(colorToBalls[prevColor] == 0) colorToBalls.erase(prevColor);
            }

            colorToBalls[color]++;
            ballToColor[ball] = color;
            result.push_back(colorToBalls.size());
        }

        return result;

    }
};