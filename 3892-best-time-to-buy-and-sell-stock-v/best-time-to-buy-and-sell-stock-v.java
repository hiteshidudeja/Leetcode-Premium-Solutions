class Solution {
    long[][][] t;
    public long solve(int i, int Case, int[] prices, int k){
        
        if(i == prices.length) {
            if(Case == 0) return 0;
            return Long.MIN_VALUE / 2;
        }

        if(t[i][k][Case] != Long.MIN_VALUE){
            return t[i][k][Case];
        }

        long notTake = solve(i + 1, Case, prices, k);

        long take = Long.MIN_VALUE;
        // case == 1 (bought now have to sell)
        // case == 2 (short sell previously now have to buy)
        if(k > 0){
            if(Case == 0){
                // either buy or short sell
                take = Math.max(-prices[i] + solve(i + 1, 1, prices, k), prices[i] + solve(i + 1, 2, prices, k));

            }
            else if(Case == 1){
                take = prices[i] + solve(i + 1, 0, prices, k - 1);
            } else if(Case == 2){
                take = -prices[i] + solve(i + 1, 0, prices, k - 1);
            }
        }

        return t[i][k][Case] = Math.max(take, notTake);
    }

    public long maximumProfit(int[] prices, int k) {
         // k, (buy -> sell) (short sell -> buy), (i)
         
         int n = prices.length;
         t = new long[n][k + 1][3];
         for(int i = 0; i < n; i++){
            for(int j = 0; j <= k; j++){
                for(int l = 0; l <=2; l++){
                    t[i][j][l]= Long.MIN_VALUE;
                }
            }
         }
         return solve(0, 0, prices, k);
        
    }
}