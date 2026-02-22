class Solution {
    public int binaryGap(int n) {
        int prev = -1; int i = 0; int result = Integer.MIN_VALUE;
        while(n > 0){
            if((n & 1) == 1) {
                if(prev != -1){
                    result = Math.max(result, i - prev);
                }
                prev = i;
            }
            i++; 
            n = n >> 1;
        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }
}