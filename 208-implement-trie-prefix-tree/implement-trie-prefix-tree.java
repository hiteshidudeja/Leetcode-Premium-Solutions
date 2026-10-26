class Trie {

   Trie[] children; boolean end;
    public Trie() {
        children = new Trie[26]; end = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }

        node.end = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }

        return node.end;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */