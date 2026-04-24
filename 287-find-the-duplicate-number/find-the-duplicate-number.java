class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n];
        for(int num : nums){
            if(frequency[num] > 0) return num;
            frequency[num]++;
        }

        return -1;
    }
}