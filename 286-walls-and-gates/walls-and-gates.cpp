class Solution {
private:
    bool possible(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
    }
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        queue<vector<int>>q;

        vector<vector<int>>directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int n = rooms.size(); int m = rooms[0].size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rooms[i][j] == 0) q.push({0, i, j});
            }
        }

        while(!q.empty()){
            auto frnt = q.front();
            q.pop();
            int dist = frnt[0]; int i = frnt[1]; int j = frnt[2];
            for(auto &direction : directions){
                int ni = i + direction[0];
                int nj = j + direction[1];
                if(!possible(ni, nj, n, m)) continue;
                if(rooms[ni][nj] <= dist + 1) continue;
                rooms[ni][nj] = dist + 1;
                q.push({dist + 1, ni, nj});
            }
        }
    }
};