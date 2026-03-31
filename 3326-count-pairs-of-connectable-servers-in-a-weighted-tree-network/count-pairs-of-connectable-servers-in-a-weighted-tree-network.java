class Solution {
    private List<List<int[]>> graph; int mod;
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        // unirected weighted tree
        // figure out how many possible pairs for each i

        int n = edges.length + 1; // A tree with n nodes has n - 1 edges
        graph = new ArrayList<>();
        mod = signalSpeed;

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // graph created
        for(int[] edge : edges){
            int a = edge[0]; int b = edge[1]; int c = edge[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            res[i] = helper(i);
        }

        return res;

    }


    private int helper(int root){
        int cumulativeChildren = 0; int pairs = 0;
        for(int[] child : graph.get(root)){
            int children = dfs(child[0], root, child[1]);
            pairs += children * cumulativeChildren;
            cumulativeChildren += children;
        }

        return pairs;
    }

    private int dfs(int node, int parent, int weight){
        int res = weight % mod == 0 ? 1 : 0;

        for(int[] neighbour : graph.get(node)){
            if(neighbour[0] == parent) continue;
            res += dfs(neighbour[0], node, weight + neighbour[1]);
        }

        return res;
    }
}