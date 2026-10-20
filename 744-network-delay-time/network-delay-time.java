class Solution {

    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();


    private void dijkstra(int[] signalReceivedAt, int source, int n){
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(Comparator.comparing(Pair:: getKey));

        pq.add(new Pair(0, source));

        signalReceivedAt[source] = 0;


        while(!pq.isEmpty()){
            Pair<Integer, Integer> topPair = pq.poll();

            int node = topPair.getValue(); int time = topPair.getKey();

            if(time > signalReceivedAt[node]) continue;

            if(!adj.containsKey(node)) continue;


            for(Pair<Integer, Integer> edge : adj.get(node)){
                int currtime = edge.getKey();
                int neighbour = edge.getValue();

                if(signalReceivedAt[neighbour] > time + currtime){
                    signalReceivedAt[neighbour] = time + currtime;
                    pq.add(new Pair(signalReceivedAt[neighbour], neighbour));
                }
            }
        }


    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // dijkstra -> 
        for(int[] time : times){
            int source = time[0]; int dest = time[1];
            int travelTime = time[2];
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }


        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dijkstra(signalReceivedAt, k, n);
        int ans = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, signalReceivedAt[i]);
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}