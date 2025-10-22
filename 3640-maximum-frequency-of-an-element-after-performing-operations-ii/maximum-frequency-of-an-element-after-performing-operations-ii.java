class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // k, nums[i] // 1 4 5 -> k = 1 numOps = 2 
        // frequency a is possible [a....n]
        // function to check if frequency a is possible

        int maxElement = Arrays.stream(nums).max().getAsInt() + k;

        TreeMap<Integer, Integer> diff = new TreeMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            int l = Math.max(0, num - k);
            int r = Math.min(num + k, maxElement);

            diff.put(l, diff.getOrDefault(l, 0) + 1);
            diff.put(r + 1, diff.getOrDefault(r + 1, 0) - 1);

            diff.putIfAbsent(num, diff.getOrDefault(num, 0));
        }


        int numEntriesWhichCanMakeTarget = 0; int result = 1;
        for(Map.Entry<Integer, Integer> entry: diff.entrySet()){
            int target = entry.getKey();
            int value = entry.getValue();

            numEntriesWhichCanMakeTarget += value;
            int already = freq.getOrDefault(target, 0);
            int conversions = numEntriesWhichCanMakeTarget - already;
            result = Math.max(result, already + Math.min(conversions, numOperations));

        }

        return result;

    }
}