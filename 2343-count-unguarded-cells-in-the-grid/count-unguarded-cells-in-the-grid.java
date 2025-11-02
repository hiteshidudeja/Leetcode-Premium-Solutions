class Solution {

    // simulation 
    private static final int GUARD = 1;
    private static final int WALL = 2;
    private static final int GUARDED = 3;
    private static final int UNGUARDED = 0;

    private void markGuarded(int row, int col, int[][] grid){
        for(int i = row + 1; i < grid.length; i++){
            if(grid[i][col] == WALL || grid[i][col] == GUARD) break;
            grid[i][col] = GUARDED;
        }

        for(int i = row - 1; i >= 0; i--){
            if(grid[i][col] == WALL || grid[i][col] == GUARD) break;
            grid[i][col] = GUARDED;
        }

        for(int i = col + 1; i < grid[0].length; i++){
            if(grid[row][i] == WALL || grid[row][i] == GUARD) break;
            grid[row][i] = GUARDED;
        }

        for(int i = col - 1; i >= 0; i--){
            if(grid[row][i] == WALL || grid[row][i] == GUARD) break;
            grid[row][i] = GUARDED;
        }


    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for(int[] guard: guards){
            grid[guard[0]][guard[1]] = GUARD;
        }

        for(int[] wall: walls){
            grid[wall[0]][wall[1]] = WALL;
        }

        for(int[] guard: guards){
            markGuarded(guard[0], guard[1], grid);
        }

        int count = 0; 

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == UNGUARDED) count++;
            }
        }

        return count;

    }
}