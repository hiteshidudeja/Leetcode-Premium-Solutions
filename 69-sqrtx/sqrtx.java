class Solution {
    public int mySqrt(int x) {
        int lo = 0; int hi = x; int ans = -1;



        while(lo <= hi){
            int mid = lo + (hi - lo) /2;
            long square = (long) mid * mid;
            if(square == x){
                return mid;
            } else if(square < x) {
                {   
                    ans = mid;
                    lo = mid + 1;
                }
            } else hi = mid - 1;
        }

        return ans;
    }
}