class Solution {

private:
    vector<vector<int>>directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int findFish(int i, int j, vector<vector<int>>& grid){
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == 0) return 0;
        int sum = grid[i][j]; grid[i][j] = 0;

        for(auto dir : directions){
            int ni = i + dir[0]; int nj = j + dir[1];
            sum += findFish(ni, nj, grid);
        }

        return sum;


    }
public:
    int findMaxFish(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int result = INT_MIN;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] > 0) {
                    int fishes = findFish(i, j, grid);
                    // cout<<fishes<<"\n";
                    result = max(result, fishes);
                };
            }
        }

        return result == INT_MIN ? 0 : result;
    }
};