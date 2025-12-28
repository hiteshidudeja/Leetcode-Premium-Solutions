class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // all events that start before possible day we can attend
        int lastDay = Integer.MIN_VALUE;
        for(int[] event: events){
            lastDay = Math.max(lastDay, event[1]);
        }
        int count = 0; 

        for(int i = 1, j = 0; i <= lastDay; i++){
            while(j < n && events[j][0] <= i){
                pq.add(events[j][1]); j++;
            }

            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll(); count++;
            }
        }

        return count;

    }
}