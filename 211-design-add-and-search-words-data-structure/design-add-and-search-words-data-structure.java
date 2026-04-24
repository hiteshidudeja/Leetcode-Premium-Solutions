class WordDictionary {

    class Trie{
        Trie[] child = new Trie[26];
        boolean end = false;
    }

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;

        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.child[idx] == null) node.child[idx] = new Trie();
            node = node.child[idx];
        }

        node.end = true;
    }

    boolean dfs(String word, int i, Trie node){
        if(node == null) return false;

        if(i == word.length()) return node.end;

        if(word.charAt(i) == '.'){
            for(int j = 0; j < 26; j++){
                if(node.child[j] != null){
                    if(dfs(word, i + 1, node.child[j])) return true;
                } 
            }

            return false;
        } else {
            int idx = word.charAt(i) - 'a';

            return dfs(word, i + 1, node.child[idx]);
        }


    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */