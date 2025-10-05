class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

       for(int i = 0; i < n; i++){
            pQueue.add(new int[]{i, 0});
            aQueue.add(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
       }


       for(int i = 0; i < m; i++){
            pQueue.add(new int[]{0, i});
            aQueue.add(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
       }

        bfs(pQueue, pacific, heights);
        bfs(aQueue, atlantic, heights);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }

        return res;



        
    }


    public void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights){

        int n = heights.length; int m = heights[0].length;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir: directions){
                int x = curr[0] + dir[0]; int y = curr[1] + dir[1];
                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y] < heights[curr[0]][curr[1]]) continue;

                visited[x][y] = true;
                queue.add(new int[]{x, y});
            }
        }
    }
}