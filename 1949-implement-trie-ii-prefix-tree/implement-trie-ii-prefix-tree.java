class Trie {

    int prefixCount, wordCount; Trie[] children;

    public Trie() {
        children = new Trie[26];
        prefixCount = 0;  wordCount = 0;
    }
    
    public void insert(String word) {
        Trie root = this;

        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(root.children[idx] == null) root.children[idx] = new Trie();
            root = root.children[idx];
            root.prefixCount++;
        }
        root.wordCount++;

        return;
    }
    
    public int countWordsEqualTo(String word) {
        Trie root = this; 

        for(char c : word.toCharArray()){
            int idx = c - 'a';

            if(root.children[idx] == null) return 0;
            root = root.children[idx];
        }

        return root.wordCount;
    }
    
    public int countWordsStartingWith(String prefix) {
        Trie root = this; 

        for(char c : prefix.toCharArray()){
            int idx = c - 'a';

            if(root.children[idx] == null) return 0;
            root = root.children[idx];
        }

        return root.prefixCount;
    }
    
    public void erase(String word) {
        Trie root = this; 
        // does this word even exist 

        for(char c : word.toCharArray()){
            int idx = c - 'a';

            if(root.children[idx] == null) return;
            root = root.children[idx];
        }

        // does this word even exist 

        if(root.wordCount == 0) return;

        // erase this word
        root = this;
        for(char c : word.toCharArray()){
            int idx = c - 'a';

            if(root.children[idx] == null) return;
            root = root.children[idx]; root.prefixCount--;
        }


        root.wordCount--;

        return;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */