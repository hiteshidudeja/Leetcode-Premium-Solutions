class Solution {
    public int countValidSelections(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int sumLeft = 0; int count = 0;
        for(int num: nums){
            sumLeft += num; int sumRight = sum - sumLeft;
            if(num == 0 && Math.abs(sumLeft - sumRight) <= 1) {
                count += ( Math.abs(sumLeft - sumRight) == 1 ? 1 : 2);
            }
        }

        return count;
    }
}