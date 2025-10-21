class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // How to find which element will we perform the operations? 
        int maxTarget = Arrays.stream(nums).max().getAsInt() + k + 1;

        int[] count = new int[maxTarget];
        for(int num: nums){
            count[num]++;
        }

        for(int i = 1; i < maxTarget; i++){
            count[i]+= count[i - 1];
        }

        int result = 0;
        for(int t = 0; t < maxTarget; t++){
            // find max of all frequencies
            int l = Math.max(0, t - k); int r = Math.min(maxTarget - 1, t + k);
            int total = count[r] - (l > 0 ? count[l - 1] : 0);
            int already = count[t] - (t > 0 ? count[t - 1] : 0);
            int opsToBePerformed = total - already;
            result = Math.max(result, already + Math.min(numOperations, opsToBePerformed));
        }

        return result;

    }
}