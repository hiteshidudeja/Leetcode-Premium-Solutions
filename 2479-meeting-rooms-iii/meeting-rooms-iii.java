class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> free = new PriorityQueue<>(); // min heap by default
        PriorityQueue<long[]> used = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]) != 0 ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])); // [endTime, roomNum];

        for(int i = 0; i < n; i++) free.add(i);

        for(int[] meeting : meetings){
            int start = meeting[0]; int end = meeting[1];
            while(!used.isEmpty() && used.peek()[0] <= start){
                int usedRoom = (int) used.peek()[1]; used.poll(); free.add(usedRoom);
            }

            if(!free.isEmpty()){
                int room = free.poll();
                used.add(new long[]{end, room}); count[room]++;
            } else {
                long[] nxt = used.poll();
                used.add(new long[]{(end + nxt[0] - start), nxt[1]});
                count[(int)nxt[1]]++;
            }
        }

        int max = 0; int res= 0;
        for(int i = 0; i < n; i++){
            if(count[i] > max){
                res = i; max = count[i];
            }
        }

        return res;
    }
}