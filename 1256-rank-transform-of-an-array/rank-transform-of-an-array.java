class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> rank = new HashMap<>();
        int[] nArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(nArr);
        int currentRank = 1;
        for(int x : nArr){
            if(rank.containsKey(x)) continue;
            rank.put(x, currentRank); currentRank++;
        }

        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            result[i] = rank.get(arr[i]);
        }

        return result;
    }
}