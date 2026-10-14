class Solution {
    int[] parent; int[] size;

    private void union(int rootU, int rootV){
        if(size[rootU] < size[rootV]){
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }


    private int find(int x){
        if(parent[x] != x) {
            return parent[x] = find(parent[x]);
        }


        return parent[x];
    }


    public int[] findRedundantConnection(int[][] edges) {
        // cycle detection
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i; size[i] = 1;
        }

        for(int[] edge : edges){
            int u = edge[0]; int v = edge[1];

            int rootU = find(u); int rootV = find(v);

            if(rootU == rootV) return edge;

            union(rootU, rootV);
        }

        return new int[0];
    }
}