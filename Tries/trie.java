class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}

class trie {
    private TrieNode root;

    public trie() {
        root = new TrieNode();
    }

    private int charToIndex(char ch) {
        return ch - 'a';
    }

    // Insert a word
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = charToIndex(ch);
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search for a word
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = charToIndex(ch);
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    // Check if any word starts with the prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = charToIndex(ch);
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        trie trie = new trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("cat");

        System.out.println(trie.search("apple"));    // true
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.search("ap"));       // false
        System.out.println(trie.startsWith("ap"));   // true
        System.out.println(trie.startsWith("ca"));   // true
        System.out.println(trie.startsWith("bat"));  // false
    }
}
