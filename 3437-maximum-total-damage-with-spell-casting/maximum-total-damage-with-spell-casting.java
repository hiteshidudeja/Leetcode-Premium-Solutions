class Solution {
    public long maximumTotalDamage(int[] power) {
        // int last = power[i] - 1; int lastSec = power[i] - 2;
        // if(power[i - 1] < power[i] -2) dp[i] = max(power[i] + dp[i - 1], dp[i - 1]);
        // if(power[i - 1] == power[i] - 2) dp[i] = max(power[i] + dp[i - 2], dp[i - 1]);

        // if(power[i - 1] == power[i] - 1) {
            // check all above conditions for power[i - 2]
        // }
        // dp[i] = max(power[i] + )

        Map<Integer, Integer> damages = new HashMap<>();
        for(int damage: power){
            damages.put(damage, damages.getOrDefault(damage, 0) + 1);
        }

        List<Integer> uniqueDamages = new ArrayList<>(damages.keySet());
        Collections.sort(uniqueDamages);
        int n = uniqueDamages.size();
        long[] dp = new long[n + 1];
        for(int i = 0; i < n; i++){
            // if taken
            int currentDamage = uniqueDamages.get(i);
            long currentDamageTotal = (long) currentDamage * damages.get(currentDamage);


            int j = i; 

            while(j > 0 && uniqueDamages.get(j - 1) >= currentDamage-2){
                j--;
            }

            long notTaken = dp[i];
            long taken = currentDamageTotal + dp[j];
            dp[i + 1] = Math.max(taken, notTaken);
        }

        return dp[n];
    }
}