class Trie {
    static TrieNode root;
    class TrieNode{        
        TrieNode[] level = new TrieNode[26];
        boolean isEndOfWord;
    }
    public Trie() {
        //This is the first level
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        //Loop through the word char by char then insert 
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if(curr.level[index]==null){//Checking the current level is already having the character or not
                curr.level[index] = new TrieNode();
            }
            curr = curr.level[index];
        }
        
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        //Loop through the word char by char then search
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if(curr.level[index]== null){//if the current level is not having the current level char
                return false;
            }
            curr = curr.level[index];
        }
        
        if(curr.isEndOfWord)
            return true;
        
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        //Loop through the word char by char then search
        for(char c:prefix.toCharArray()){
            int index = c - 'a';
            if(curr.level[index] == null){
                return false;
            }
            curr = curr.level[index];
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