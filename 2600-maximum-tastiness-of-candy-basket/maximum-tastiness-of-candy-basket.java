class Solution {

    public boolean possible(int tastiness, int[] price, int k){
        int count = 1;
        int last = price[0]; int i = 1;
        while(i < price.length && count < k){
            if(price[i] - last >= tastiness) {
                count++; last = price[i];
            }
            i++;
        }

        return count == k;
    }
    public int maximumTastiness(int[] price, int k) {
        // maximise the min difference 
        int n = price.length;
        Arrays.sort(price);
        int lo = 0; int hi = 1000000000;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(possible(mid, price, k)){
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;

    }
}