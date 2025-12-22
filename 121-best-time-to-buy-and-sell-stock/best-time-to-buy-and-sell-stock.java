class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; 
        int boughtPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            boughtPrice = Math.min(boughtPrice, prices[i]);
            profit = Math.max(profit, prices[i] - boughtPrice);
        }

        return profit;
    }
}