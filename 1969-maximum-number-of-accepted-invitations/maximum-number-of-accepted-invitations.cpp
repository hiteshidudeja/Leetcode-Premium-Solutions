class Solution {
private:
    bool possibleMatch(int b, vector<vector<int>>& grid, vector<int>&seen, vector<int>&match){
        for(int i = 0; i < grid[0].size(); i++){
            if(grid[b][i] && !seen[i]){
                seen[i] = true;

                if(match[i] < 0 || possibleMatch(match[i], grid, seen, match)){
                    match[i] = b;
                    return true;
                }
            }
        }

        return false;
    }
public:
    int maximumInvitations(vector<vector<int>>& grid) {
        int nb = grid.size();
        int ng = grid[0].size();
        vector<int>match(ng, -1); int result = 0;

        for(int boy = 0; boy < nb; boy++){
            vector<int>seen(ng, false);
            if(possibleMatch(boy, grid, seen, match)) result++;
        }

        return result;
    }
};