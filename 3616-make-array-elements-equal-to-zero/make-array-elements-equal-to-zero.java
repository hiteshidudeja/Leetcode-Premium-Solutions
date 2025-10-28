class Solution {

    private boolean isPossible(int sum, int half){
        // 39 -> 19, 20
        // 40 -> 20
        if(sum % 2 == 1 && half == (sum + 1) / 2) return true;
        return half == sum / 2;
    }
    public int countValidSelections(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0; int count = 0;
        for(int num: nums){
            if(num == 0 && isPossible(sum, total)) {
                if(sum % 2 == 1) count += 1;
                else count += 2;
            }
            total += num;
        }

        return count;
    }
}