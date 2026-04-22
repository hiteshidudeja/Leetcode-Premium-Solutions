class Solution { 
    class Trie{
        Trie[] child = new Trie[26];
        boolean end = false;
    }

    Trie root = new Trie();

    void insert(String word){
        Trie node = root;

        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.child[idx] == null) node.child[idx] = new Trie();
            node = node.child[idx];
        }

        node.end = true;

    }


    boolean dfs(String word, int i, Trie node, int count){
        if(count > 2 || node == null) return false;

        if(i == word.length()) return node.end;

        int idx = word.charAt(i) - 'a';

        if(node.child[idx] != null) {
            if(dfs(word, i + 1, node.child[idx], count)) return true;
        }

        if(count < 2) {
            // scope of changing
            for(int c = 0; c < 26; c++){
                if(c == idx) continue;
                if(node.child[c] != null){
                    if(dfs(word, i + 1, node.child[c], count + 1)) return true;
                }
            }
        }

        return false;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary)     {
        
        for(String s : dictionary) insert(s);
        List<String> result = new ArrayList<>();
        for(String q : queries){
            if(dfs(q, 0, root, 0)) 
                result.add(q);
        }

        return result;
    }
}