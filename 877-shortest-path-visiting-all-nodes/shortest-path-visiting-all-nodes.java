class Solution {
    public int shortestPathLength(int[][] graph) {
        // visit all nodes - compulsory
        // shortest path

        int n = graph.length;

        int targetMask = (1 << n) - 1;

        boolean[][] visited = new boolean[n][1 << n];

        Queue<int[]> queue = new LinkedList<>();


        for(int i = 0; i < n; i++){
            int mask = (1 << i);
            queue.offer(new int[]{i, mask, 0});
            visited[i][mask] = true;
        }
        

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int node = curr[0]; int mask = curr[1]; int dist = curr[2];

            if(mask == targetMask) return dist;

            for(int next : graph[node]){
                int newMask = mask | (1 << next);

                if(!visited[next][newMask]){
                    visited[next][newMask] = true;
                    queue.offer(new int[]{next, newMask, dist + 1});
                }
            }
        }


        return -1;
    }
}