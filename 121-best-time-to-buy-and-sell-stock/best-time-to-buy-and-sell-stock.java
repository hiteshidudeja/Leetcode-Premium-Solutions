class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int boughtPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < n; i++){
            boughtPrice = Math.min(boughtPrice, prices[i]);
            profit = Math.max(profit, prices[i] - boughtPrice);
        }

        return profit;
    }
}