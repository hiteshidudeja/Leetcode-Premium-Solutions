class Solution {
    int[] state;

    private boolean dfs(int node, int[][] graph){
        if(state[node] == 1) return false;
        if(state[node] == 2) return true;

        state[node] = 1;

        for(int neighbour : graph[node]){
            if(!dfs(neighbour, graph)) return false;
        }


        state[node] = 2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        state = new int[n];

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(dfs(i, graph)) result.add(i);
        }

        return result;

    }
}