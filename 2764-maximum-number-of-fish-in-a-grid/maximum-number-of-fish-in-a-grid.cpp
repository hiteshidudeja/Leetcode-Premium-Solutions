class Solution {
private:
    int findFish(int i, int j, vector<vector<int>>& grid, vector<vector<bool>>& visited){
        vector<vector<int>>directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue<pair<int, int>>q; q.push({i, j});
    

        int n = grid.size(); int m = grid[0].size();

        int sum = 0;
        while(!q.empty()){
            auto tp = q.front(); q.pop();
            int r = tp.first; int c = tp.second;
            // cout<<r<<" "<<c<<"\n";
            if(visited[r][c]) continue;
            visited[r][c] = true;
            if(grid[r][c] == 0) continue;
            sum += grid[r][c];

            for(auto dir : directions){
                int nr = r + dir[0]; int nc = c + dir[1];
                if(nr <0 || nr >= n || nc < 0 || nc >= m) continue;
                q.push({nr, nc});
            }
        }

        return sum;
    }
public:
    int findMaxFish(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>>visited(n, vector<bool>(m, false));

        int result = INT_MIN;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(!visited[i][j]) {
                    int fishes = findFish(i, j, grid, visited);
                    // cout<<fishes<<"\n";
                    result = max(result, fishes);
                };
            }
        }

        return result;
    }
};