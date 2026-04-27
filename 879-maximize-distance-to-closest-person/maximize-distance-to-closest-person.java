class Solution {
    public int maxDistToClosest(int[] seats) {
        // bw two onwa 

        int pre = -1, suf = -1, max = -1, zeros = 0;

        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0){
                zeros++;
            } else {
                if(pre == -1) pre = zeros;
                else {
                    max = Math.max(max, zeros);
                }
                zeros = 0;
            }
        }

        suf = zeros;
        return Math.max(Math.max(pre, suf), (max + 1)/2);
    }
}