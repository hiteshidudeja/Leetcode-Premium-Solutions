class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>>pq;

        vector<vector<int>>directions = {{0, 1}, {1, 0}};

        int n = grid.size(); int m = grid[0].size();

        vector<vector<int>>dist(n, vector<int>(m, INT_MAX));
        dist[0][0] = grid[0][0]; pq.push({grid[0][0], 0, 0});

        while(!pq.empty()){
            auto temp = pq.top();
            int distance = temp[0]; int i = temp[1]; int j = temp[2];
            pq.pop();
            if(i == n - 1 && j == m - 1) return distance;
            if(dist[i][j] != distance) continue;
            for(auto &direction: directions){
                int ni = i + direction[0]; int nj = j + direction[1];
                if(ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                if(distance + grid[ni][nj] < dist[ni][nj]){
                    pq.push({distance + grid[ni][nj], ni, nj});
                    dist[ni][nj] = distance + grid[ni][nj];
                }
            }
            
        }

        return dist[n - 1][m - 1];
    }
};