class Solution {
    public int trap(int[] height) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        int l = 0; int r = height.length - 1;
        int lmax = height[l]; int rmax = height[r]; int water = 0;
        while(l < r){
            if(lmax < rmax){
                l++;
                lmax = Math.max(height[l], lmax);
                water += lmax - height[l];
            } else {
                r--;
                rmax = Math.max(rmax, height[r]);
                water += rmax - height[r];
            }
        }


        return water;
    }
}                                      