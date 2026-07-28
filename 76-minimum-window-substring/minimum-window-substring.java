class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(); int m = t.length();

        if(n < m) return "";    int count = m;

        int[] map = new int[128];

        int start = 0; int end = 0; int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while(end < n){
            if(map[chS[end++]]-- > 0){
                count--;
            }

            while(count == 0){
                if(end - start < minLength){
                    startIndex = start;
                    minLength = end - start;
                }

                if(map[chS[start++]]++ == 0){
                    count++;
                }
            }
        } 

        return minLength == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLength);
        

    }
}