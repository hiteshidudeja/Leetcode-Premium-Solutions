class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<int>rowNums(n, 0);
        vector<int>colNums(m, 0);
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) {
                    rowNums[i]++; colNums[j]++;
                }
            }
        }


        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(colNums[j] > 1 || rowNums[i] > 1) count++;
                }
            }
        }


        return count;
    }
};