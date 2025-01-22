class Solution {
private:
    bool possible(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
    }
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        // mutisource BFS
        int n = isWater.size();
        int m = isWater[0].size();

        // directions
        vector<vector<int>>directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue<pair<int, int>>q;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isWater[i][j] != 1) isWater[i][j] = -1;
                else {
                    isWater[i][j] = 0;
                    q.push({i, j});
                }   
            }
        }

        while(!q.empty()){
            auto tp = q.front();
            q.pop();
            int i = tp.first; int j = tp.second;
            for(auto direction: directions){
                int ni = i + direction[0]; int nj = j + direction[1];
                if(!possible(ni, nj, n, m)) continue;
                if(isWater[ni][nj] == -1) {
                    isWater[ni][nj] = isWater[i][j] + 1;
                    q.push({ni, nj});
                }
            }
        }

        return isWater;
    }
};