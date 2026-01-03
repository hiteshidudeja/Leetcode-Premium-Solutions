class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        // ABA pattern -> ABA ways (3), ABC (2)
        // ABC pattern -> ABA ways (2), ABC (2)
        long a = 6; long b = 6;
        for(int i = 1; i < n; i++){
            long na = (3 * a + 2 * b) % MOD;
            long nb = (2 * a + 2 * b) % MOD;
            a = na; b = nb;
        }

        return (int)((a + b) % MOD);
    }
}