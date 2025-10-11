class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num,0) + 1);
        }


        List<Integer> list = new ArrayList<>(count.keySet());
        Collections.sort(list);

        int n = list.size();

        int[] dp = new int[n + 1];

        for(int i = 0; i < n; i++){
            int element = list.get(i);
            int taken = element * count.get(element);
            int j = i;

            if(j > 0 && list.get(j - 1) != element - 1){
                taken += dp[j];
            } else {
                if(j > 0) taken += dp[j - 1];
            }


            int notTaken = dp[i];

            dp[i + 1] = Math.max(taken, notTaken);
        }

        return dp[n];
    }
}