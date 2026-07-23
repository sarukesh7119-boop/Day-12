class MagicDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        public TrieNode() {}
    }
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    public void buildDict(String[] dict) {
        for (String s : dict) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (arr[i] == c) {
                    continue;
                }
                char org = arr[i];
                arr[i] = c;
                if (helper(new String(arr), root)) {
                    return true;
                }
                arr[i] = org;
            }
        }
        return false;
    }
    public boolean helper(String s, TrieNode root) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }
}