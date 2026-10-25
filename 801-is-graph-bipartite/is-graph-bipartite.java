class Solution {
    int[] state;

    private boolean dfs(int node, int[][] graph, int color){

        state[node] = color;

        for(int neighbour: graph[node]){
            if(state[neighbour] == 0) {
                if(!dfs(neighbour, graph, -1 * color)) return false;
            } else if(state[neighbour] == color)
                return false;
            }

          return true;
        }

    
    
    public boolean isBipartite(int[][] graph) {
        //. check whether the graph has cycle or not
        int n = graph.length;
        state = new int[n];
        for(int i = 0; i < n; i++){
            if(state[i] == 0) if(!dfs(i, graph, 1)) return false;
        }

        return true;
    }
}