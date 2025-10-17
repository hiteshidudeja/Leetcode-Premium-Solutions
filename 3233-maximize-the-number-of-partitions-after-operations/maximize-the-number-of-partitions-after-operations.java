class Solution {
    private HashMap<Long, Integer> cache;
    private String s;
    private int k;


    private int dp(int index, int currentSet, boolean canChange){
        long key = ((long) index << 27) | ((long) currentSet << 1) | (canChange ? 1: 0);

        if(cache.containsKey(key)) return cache.get(key);

        if(index == s.length()) return 0;

        int charIndex = s.charAt(index) - 'a';
        int currentSetUpdated = currentSet | (1 << charIndex);
        int distinctCount = Integer.bitCount(currentSetUpdated);

        int res;
        if(distinctCount > k){
            res = 1 + dp(index + 1, 1 << charIndex, canChange);
        } else res = dp(index + 1, currentSetUpdated, canChange);

        if(canChange){
            for(int i = 0; i < 26; i++){
                int newSet = currentSet | (1 << i);
                int newDistinctCount = Integer.bitCount(newSet);

                if(newDistinctCount > k){
                    res = Math.max(res, 1 + dp(index + 1, 1 << i, false));
                } else res = Math.max(res, dp(index +1, newSet, false));
            }
        }

        cache.put(key, res);
        return res;
    }
    public int maxPartitionsAfterOperations(String s, int k) {
        // dc == k (dc + 1)
        this.cache = new HashMap<>();
        this.s = s;
        this.k = k;
        return dp(0, 0, true) + 1;
    }
}