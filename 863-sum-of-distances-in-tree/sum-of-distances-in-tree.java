class Solution {
    private List<Integer>[] graph;
    private int[] subtreeSize;
    private int[] answer;
    private int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;

        graph = new ArrayList[n];
        subtreeSize = new int[n];
        answer = new int[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }


        for(int[] edge : edges){
            int u = edge[0]; int v = edge[1];
            graph[u].add(v); graph[v].add(u);
        }


        calculateSubtreeInfo(0, -1);
        reroot(0, -1);

        return answer;
        
    }


    private void calculateSubtreeInfo(int node, int parent){
        subtreeSize[node] = 1;

        for(int neighbour: graph[node]){
            if(parent == neighbour) continue;

            calculateSubtreeInfo(neighbour, node);

            subtreeSize[node] += subtreeSize[neighbour];

            answer[node] += answer[neighbour] + subtreeSize[neighbour];
        }
    }


    private void reroot(int node, int parent){

        for(int neighbour : graph[node]){
            if(neighbour == parent) continue;

            answer[neighbour] = answer[node] - subtreeSize[neighbour] + n - subtreeSize[neighbour];

            reroot(neighbour, node);
        }
    }
}