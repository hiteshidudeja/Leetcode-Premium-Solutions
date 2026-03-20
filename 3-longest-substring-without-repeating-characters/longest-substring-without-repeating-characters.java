class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        Map<Character, Integer> map = new HashMap<>();
        int start = 0; int len = 0;
        for(int end = 0; end < n; end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(map.get(c) + 1, start);
            }

            len = Math.max(len, end - start + 1);
            map.put(c, end);
        }

        return len;
    }
}