class Solution {
    private List<String> dictionary;
    private Map<Integer, Boolean> memo = new HashMap<>();
    boolean solve(int i, String s){
        if(i == s.length()) return true;
        if(memo.containsKey(i)) return memo.get(i);
        for(int p = i + 1; p <= s.length(); p++){        
            if(dictionary.contains(s.substring(i, p)) && solve(p, s)){
                memo.put(i, true);
                return true;
            }
        }

        memo.put(i, false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dictionary = wordDict;
        return solve(0, s);
    }
}