class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        int n = grid.size(); int m = grid[0].size();

        int zeroes = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) zeroes++;
            }
        }

        if(zeroes == 0) return 0;

        int ans = INT_MAX;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    for(int ni = 0; ni < n; ni++){
                        for(int nj = 0; nj < n; nj++){
                            int dis = abs(ni - i) + abs(nj - j);
                            if(grid[ni][nj] > 1){
                                grid[ni][nj]--;
                                grid[i][j]++;
                                ans = min(ans, dis + minimumMoves(grid));
                                grid[ni][nj]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
};