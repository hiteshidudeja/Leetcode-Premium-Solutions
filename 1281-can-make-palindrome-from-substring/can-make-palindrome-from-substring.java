class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // how many distinct characters are there b/w left right 
        // if distinct characters - k <= (right - left + 2)/2 

        // optimal way to find number of distinct characters in a substring [l, r]      

        int n = s.length();
        // number of odd frequency bits
        int[] prefix = new int[n + 1]; 
        
        for(int i = 0; i < n; i++){
            int bit = (1 << s.charAt(i));
            prefix[i + 1] = prefix[i] ^ bit;
        }

        List<Boolean> result = new ArrayList<>();

        for(int[] query: queries){
            int l = query[0]; int r = query[1]; int k = query[2];
            int numOdds = prefix[r + 1] ^ prefix[l];
            int oddBits = Integer.bitCount(numOdds);
            if(oddBits / 2 <= k){
                result.add(true);
            } else result.add(false);
        }

        return result;

    }
}