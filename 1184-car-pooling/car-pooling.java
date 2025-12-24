class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] lineSweep = new int[1002];

        for(int[] trip : trips){
            int numPassengers = trip[0]; int start = trip[1]; int end = trip[2];
            lineSweep[start] += numPassengers;
            lineSweep[end] -= numPassengers;
        }

        for(int i = 0; i < lineSweep.length; i++){
            if(i > 0)
                lineSweep[i] += lineSweep[i - 1];
            if(lineSweep[i] > capacity) return false;
        }

        return true;
    }
}