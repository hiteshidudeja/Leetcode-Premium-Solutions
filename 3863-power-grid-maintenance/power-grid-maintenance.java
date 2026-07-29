class Solution {

    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n + 1]; rank = new int[n + 1];
            for(int i = 1; i <= n; i++) parent[i] = i;
        }


        int find(int x){
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }


        void union(int a , int b){
            int rootA = find(a); int rootB = find(b);

            if(rootA == rootB) return;
            if(rank[rootA] < rank[rootB]){
                parent[rootA] = rootB;
            } else if(rank[rootA] > rank[rootB]){
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // union of 2 nodes
        // disjoint set union

        DSU dsu = new DSU(c);

        for(int[] edge : connections){
            dsu.union(edge[0], edge[1]);
        }


        Map<Integer, PriorityQueue<Integer>> componentHeap = new HashMap<>();

        for(int i = 1; i <= c; i++){
            int root = dsu.find(i);
            componentHeap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> answer = new ArrayList<>();

        for(int[] query : queries){
            int type = query[0]; int station = query[1];

            if(type == 2) online[station] = false;
            else {
                if(online[station]){
                    answer.add(station); continue;
                }


                int root = dsu.find(station);
                PriorityQueue<Integer> heap = componentHeap.get(root);

                while(!heap.isEmpty() && !online[heap.peek()]){
                    heap.poll();
                }

                answer.add(heap.isEmpty() ? -1 : heap.peek());
            }
        }



        return answer.stream().mapToInt(Integer::intValue).toArray();


    }
}