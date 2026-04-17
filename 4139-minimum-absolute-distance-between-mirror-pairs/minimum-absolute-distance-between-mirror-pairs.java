class Solution {
    private int reverse(int num){
        int rev = 0;
        while(num > 0){
            int rem = num % 10;
            num = num / 10;
            rev = rev * 10 + rem;
        }

        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        // reverse of a number -> O(9)
        // hashmap 
        // min dist b/w indices 
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length; int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int rev = reverse(nums[i]);
            // System.out.println(rev);
            if(map.containsKey(nums[i])){
                res = Math.min(res, Math.abs(i - map.get(nums[i])));
            }

            map.put(rev, i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}