class Solution {
private:
    int dp[101][1024] = {}; int MOD = 1e9 + 7;
    void findPossibleWays(int w, int width, vector<int>& bricks, int mask, vector<int>& masks){
        if(w == width) masks.push_back(mask);
        if(w > 0){
            mask |= 1 << (w - 1);
        }
        for(auto brick : bricks){
            if(w + brick <= width){
                findPossibleWays(w + brick, width, bricks, mask, masks);
            }
        }
    }

    int findWays(int h, int prev, int height, vector<int>&masks){
        if(h == height) return 1;
        int count = 0;
        if(dp[h][prev]!=0) return dp[h][prev];
        for(auto mask : masks){
            if((mask & prev) == 0){
                // cout<<count<<"\n";
                count = (count%MOD + findWays(h + 1, mask, height, masks)%MOD)%MOD;
            }
        }

        return dp[h][prev] = count;
    }
public:
    int buildWall(int height, int width, vector<int>& bricks) {
        // suppose the height is 1 & we have been given bricks 
        // in that case this problem becomes the problem of standard coin change
        // whenever we have found the answer of a row, we need to keep the brick endings 
        // before we process the next row right?
        // we can go from t -> b OR b -> t

        // dry run  // 1 2

        // All possible arrangements are given! 
        // 0 1 0 1 0, 0 0 1 1 0, 0 1 0 1 1
        // map of arrangements 
        // 0 1 0 1 0 -> 0 0 1 0 1, 1 0 1 0 1, 1 0 0 0 0, 1 0 1 0 0

        // 
        vector<int>masks;
        findPossibleWays(0, width, bricks, 0, masks);

        // all possible arrangements
        // for(auto mask : masks) cout<<mask<<" ";
        return findWays(0, 0, height, masks);

        
     
    }
};