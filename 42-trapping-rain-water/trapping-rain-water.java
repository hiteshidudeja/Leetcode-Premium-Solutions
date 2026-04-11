class Solution {
    public int trap(int[] height) {
        int lmax = Integer.MIN_VALUE; int rmax = Integer.MIN_VALUE;

        int i = 0; int j = height.length - 1; int water = 0;

        while(i < j){
            if(height[i] <= height[j]){
                lmax = Math.max(lmax, height[i]);
                water += lmax - height[i];
                i++;
            } else {
                rmax = Math.max(rmax, height[j]);
                water += rmax - height[j]; j--;
            }
        }

        return water;
    }
}