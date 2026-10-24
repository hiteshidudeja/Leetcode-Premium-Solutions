class Solution {
    int[] parent; int[] size;
    private boolean union(int a, int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA == rootB) return true;

        if(size[rootA] > size[rootB]){
            parent[rootB] = rootA; size[rootA]+=size[rootB];
        } else {
            parent[rootA] = rootB; size[rootB]+=size[rootA];
        }

        return false;
    }

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        parent = new int[n]; size = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(size, 1);

        for(int[] edge : edges){
            int u = edge[0]; int v = edge[1];
            if(union(u, v)) return false;
        }

        return true;
    }
}