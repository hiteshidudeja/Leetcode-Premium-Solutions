class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // kya logic lagega
        // longer path might have lesser number of buses
        // shorter path might have more buses
        // vice vers

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for(int bus = 0; bus < routes.length; bus++){
            for(int stop : routes[bus]){
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }

        if(source == target) return 0;

        if(!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) return -1;


        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> busesTaken = new HashSet<>();

        Set<Integer> stopsVisited = new HashSet<>();

        int res = 0;

        queue.offer(source);
        stopsVisited.add(source);

        while(!queue.isEmpty()){
            res++;
            int stopsToProcess = queue.size();
            for(int i = 0; i < stopsToProcess; i++){
                int currStop = queue.poll();

                for(int busId : stopToBuses.getOrDefault(currStop, new ArrayList<>())){
                    if(busesTaken.contains(busId)) continue;

                    busesTaken.add(busId);

                    for(int nextStop : routes[busId]){
                        if(stopsVisited.contains(nextStop)) continue;

                        if(nextStop == target) return res;

                        queue.offer(nextStop);
                        stopsVisited.add(nextStop);
                    }
                }
            }
        }

        return -1;

    }
}