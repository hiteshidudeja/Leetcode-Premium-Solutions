class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                result.add(nums[i]);

            map.put(nums[i], map.getOrDefault(nums[i], 0));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}