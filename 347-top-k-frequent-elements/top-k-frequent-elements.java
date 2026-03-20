class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b)-> b.getValue().compareTo(a.getValue()));

        int[] result = new int[k]; int i = 0;
        for(Map.Entry<Integer, Integer> entry : list){
            result[i] = entry.getKey(); i++;
            if(k == i) return result;
        }

        return result;
    }
}