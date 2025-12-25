class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0; 
        int kids = 0;
        Arrays.sort(happiness); int n = happiness.length;
        for(int i = n - 1; i >=0 ; i--){
            sum += Math.max(0, happiness[i] - kids);
            kids++;
            if(kids == k) return sum;
        }

        return sum;
    }
}