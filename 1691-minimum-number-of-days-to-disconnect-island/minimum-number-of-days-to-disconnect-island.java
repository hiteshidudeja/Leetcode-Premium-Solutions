class Solution {
    int n, m;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    

    private void dfs(int i, int j, int[][] grid, boolean[][] visited){
        visited[i][j] = true;

        for(int[] d : directions){
            int ni = i + d[0]; int nj = j + d[1];
            if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 1 && !visited[ni][nj]){
                dfs(ni, nj, grid, visited);
            }
        }
    }


    private int countIslands(int[][] grid){
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++; dfs(i, j, grid, visited);
                }
            }
        }

        return count;
    }
    public int minDays(int[][] grid) {
        // if there exist a critical edge -> 1
        // otherwise return 2
        n = grid.length; m = grid[0].length;

        if(countIslands(grid) != 1) return 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(countIslands(grid)!= 1) return 1;

                    grid[i][j] = 1;
                }
            }
        }

        return 2;

    }
}