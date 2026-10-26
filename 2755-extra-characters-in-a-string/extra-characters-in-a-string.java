class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1]; Arrays.fill(dp, Integer.MAX_VALUE); dp[0] = 0;


        for(int i = 0; i < n; i++){
            // if this is extra char
            dp[i + 1] = Math.min(dp[i + 1], 1 + dp[i]);

            // if this is a part of substring

            for(String word : dictionary){
                int start = i - word.length() + 1;
                if(start >= 0 && s.substring(start, i + 1).equals(word)){
                    dp[i + 1] = Math.min(dp[i + 1], dp[start]);
                }
            }
        }

        return dp[n];
    }
}