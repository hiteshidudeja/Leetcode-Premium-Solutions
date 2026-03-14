class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer, Integer> total = new HashMap<>();
        Map<Integer, Integer> count1 = new HashMap<>();

        for(int num : nums1){
            count1.put(num, count1.getOrDefault(num, 0) + 1);
            total.put(num, total.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2){
            total.put(num, total.getOrDefault(num, 0) + 1);
        }

        int swaps = 0;

        for(int key : total.keySet()){
            if(total.get(key) % 2 != 0) return -1;

            int target = total.get(key) / 2;

            int extra = Math.max(0, count1.getOrDefault(key, 0) - target);

            swaps += extra;
        }

        return swaps;



    }
}