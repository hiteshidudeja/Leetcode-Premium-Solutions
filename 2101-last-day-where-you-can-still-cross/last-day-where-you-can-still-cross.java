class Solution {
    private boolean canCrossOnDay(int day, int[][] cells, int row, int col){
        int[][] grid = new int[row][col];

        for(int i = 0; i < day; i++){
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < col; i++) {
            if(grid[0][i] == 0) {
                q.offer(new int[]{0, i});
                visited[0][i] = true;
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0]; int c = curr[1];
            if(r == row - 1) return true;

            for(int[] dir: directions){
                int nr = r + dir[0]; int nc = c + dir[1];

                if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc] == true || grid[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }


        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        // check if a path exist from top row to bottom row 
        // binary search  on day 

        int days = cells.length;
        int lo = 1; int hi = days;
        int ans = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(canCrossOnDay(mid, cells, row, col)){
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }

        return ans;
    }
}