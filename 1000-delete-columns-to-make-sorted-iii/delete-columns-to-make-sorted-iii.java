class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int[] dp = new int[cols];
        Arrays.fill(dp, 1); int result = cols - 1;
        int k;
        for(int j = 0; j < cols; ++j){
            for(int i = 0; i < j; ++i){
                for(k = 0; k < rows; ++k){
                    if(strs[k].charAt(i) > strs[k].charAt(j)) break;
                }

                if(k == rows){
                    // all rows are sorted
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            result = Math.min(result, cols - dp[j]);


        }

        return result;

    }
}