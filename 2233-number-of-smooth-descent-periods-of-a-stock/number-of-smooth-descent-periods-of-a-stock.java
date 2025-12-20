class Solution {
    public long getDescentPeriods(int[] prices) {
        int count = 1; 
        int n = prices.length; long result = n;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] - prices[i + 1] == 1) count++;
            else {
                result += ((long)count * (count - 1)) / 2;
                count = 1;
            }
        }

    
        result+= ((long)count * (count - 1)) / 2;

    

        return result;
    }
}