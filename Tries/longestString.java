import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }
}

public class LongestString {
    static String ans = "";
    
    public static void dfs(TrieNode node, String cur) {
        if (!node.isEnd && cur.length() > 0) return;
        if (cur.length() > ans.length() || (cur.length() == ans.length() && cur.compareTo(ans) < 0))
            ans = cur;
        for (int i = 0; i < 26; i++)
            if (node.children[i] != null)
                dfs(node.children[i], cur + (char)(i + 'a'));
    }
    
    public static String longestWordWithAllPrefixes(String[] words) {
        Trie trie = new Trie();
        for (String w : words) trie.insert(w);
        ans = "";
        dfs(trie.root, "");
        return ans;
    }
    
    public static void main(String[] args) {
        String[] words = {"a","ap","app","appl","apple","apply"};
        System.out.println(longestWordWithAllPrefixes(words)); // apple
    }
}
