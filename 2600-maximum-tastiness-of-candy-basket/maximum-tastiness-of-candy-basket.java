class Solution {
    public boolean possible(int tastiness, int[] price, int k){
        int count = 1;
        int last = price[0]; int i = 1;

        while(count < k && i < price.length){
            if(price[i] - last >= tastiness) {
                last = price[i];
                count++; 
            }
            i++;
        }

        return count == k;
    }
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int lo = 0; int hi = price[n - 1] - price[0];
        while(lo < hi){
            int mid = 1 + lo + (hi - lo)/2;
            if(possible(mid, price, k)) lo = mid;
            else hi = mid - 1;
        }

        return lo;
    }
}