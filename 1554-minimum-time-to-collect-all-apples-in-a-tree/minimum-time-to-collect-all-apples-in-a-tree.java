class Solution {
    // graph is described as tree 

    private int dfs(List<List<Integer>> graph, int node, int parent, List<Boolean> hasApple){
        int totalTime = 0;
        for(int neighbour : graph.get(node)){
            if(parent == neighbour) continue;

            int childTime = dfs(graph, neighbour, node, hasApple);
            if(childTime > 0 || hasApple.get(neighbour)) {
                totalTime += childTime + 2;
            }
        }

       return totalTime;

    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }


        for(int[] edge : edges){
            int from = edge[0]; int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }


        return dfs(graph, 0, -1, hasApple);

    }
}