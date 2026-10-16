class Solution {
    private int n, m;

    private int[][] directions = {{1, 0},  {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(int i, int j, int[][] heights, boolean[][] visited){
        if(visited[i][j]) return;
        visited[i][j] = true;

        for(int[] d : directions){
            int x = i + d[0]; int y = j + d[1];

            if(x < 0 || x >= n || y < 0 || y >= m) continue;

            if(heights[x][y] < heights[i][j]) continue;

            dfs(x, y, heights, visited);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;  m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];

        boolean[][] atlantic = new boolean[n][m];

        for(int i = 0; i < m; i++) dfs(0, i, heights, pacific);

        for(int i = 0; i < n; i++) dfs(i, 0, heights, pacific);

        for(int j = 0; j < m; j++) dfs(n - 1, j, heights, atlantic);

        for(int i = 0; i < n; i++) dfs(i, m - 1, heights, atlantic);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }
}