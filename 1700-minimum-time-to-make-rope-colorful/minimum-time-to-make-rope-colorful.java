class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;

        for(int i = 0; i < colors.length(); i++){
            int max = Integer.MIN_VALUE; int sum = 0;
            if(i > 0 && colors.charAt(i) == colors.charAt(i - 1)){
                max = neededTime[i - 1];
                sum += neededTime[i - 1];
            }
            while(i > 0 && i < colors.length() && colors.charAt(i) == colors.charAt(i - 1)){
                max = Math.max(max, neededTime[i]); 
                sum += neededTime[i]; i++;
            }

            cost += sum - (max == Integer.MIN_VALUE ? 0 : max);           
        }

        return cost;
    }
}