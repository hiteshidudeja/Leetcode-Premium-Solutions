class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        int res = 0, i = 0, maxFrequency = 0;

        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequency.get(c));

            while((j - i + 1) - maxFrequency > k){
                char left = s.charAt(i);
                frequency.put(left, frequency.get(left) - 1);
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}