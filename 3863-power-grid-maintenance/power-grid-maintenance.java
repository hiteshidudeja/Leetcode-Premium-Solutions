class DSU{
    int[] parent;

    public DSU(int n){
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;
    }

    public void union(int x, int y){
        int px = find(x); int py = find(y);
        if(px == py) return;
        parent[py] = px;
    }


    public int find(int val){
        if(parent[val] == val) return val;
        return parent[val] = find(parent[val]);
    }
}


class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        for(int[] con : connections){
            dsu.union(con[0], con[1]);
        } 

        Map<Integer, PriorityQueue<Integer>> heap = new HashMap<>();
        for(int i = 1; i <=c; i++){
            int root = dsu.find(i);
            heap.putIfAbsent(root, new PriorityQueue<>());
            heap.get(root).offer(i);
        }

        List<Integer> result = new ArrayList<>();

        for(int[] query: queries){
            int op = query[0], x = query[1];

            if(op == 2) {
                online[x] = false;
            } else {
                if(online[x]) result.add(x);
                else {
                    int root = dsu.find(x);
                    PriorityQueue<Integer> h = heap.get(root);

                    while(!h.isEmpty() && !online[h.peek()]) h.poll();
                    result.add(h.isEmpty()? -1 : h.peek());
                }
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;

    }
}