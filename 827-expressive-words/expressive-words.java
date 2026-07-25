class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for(String word : words){
            if(stretchy(s, word)) ans++;
        }

        return ans;
    }


    private boolean stretchy(String s, String word){
        if(word == null) return false;

        int i = 0; int j = 0;

        while(i < s.length() && j < word.length()){
            if(s.charAt(i) == word.charAt(j)){
                int len1 = getRepeatedLength(s, i);
                int len2 = getRepeatedLength(word, j);

                if(len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) return false;

                i += len1; j += len2;
            } else return false;
        }


        return i == s.length() && j == word.length();
    }


    private int getRepeatedLength(String s, int i){
        int j = i;

        while(j < s.length() && s.charAt(j) == s.charAt(i)) j++;

        return j - i;
    }
}