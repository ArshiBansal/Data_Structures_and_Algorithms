#include <iostream>
using namespace std;

class TrieNode {
public:
    TrieNode* children[26];
    bool isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = nullptr;
    }
};

class Trie {
private:
    TrieNode* root;

    int charToIndex(char ch) {
        return ch - 'a';
    }

public:
    Trie() {
        root = new TrieNode();
    }

    // Insert a word
    void insert(string word) {
        TrieNode* node = root;
        for (char ch : word) {
            int index = charToIndex(ch);
            if (!node->children[index])
                node->children[index] = new TrieNode();
            node = node->children[index];
        }
        node->isEndOfWord = true;
    }

    // Search for a word
    bool search(string word) {
        TrieNode* node = root;
        for (char ch : word) {
            int index = charToIndex(ch);
            if (!node->children[index])
                return false;
            node = node->children[index];
        }
        return node->isEndOfWord;
    }

    // Check if any word starts with the prefix
    bool startsWith(string prefix) {
        TrieNode* node = root;
        for (char ch : prefix) {
            int index = charToIndex(ch);
            if (!node->children[index])
                return false;
            node = node->children[index];
        }
        return true;
    }
};

int main() {
    Trie trie;
    trie.insert("apple");
    trie.insert("app");
    trie.insert("cat");

    cout << trie.search("apple") << endl;     // 1 (true)
    cout << trie.search("app") << endl;       // 1 (true)
    cout << trie.search("ap") << endl;        // 0 (false)
    cout << trie.startsWith("ap") << endl;    // 1 (true)
    cout << trie.startsWith("ca") << endl;    // 1 (true)
    cout << trie.startsWith("bat") << endl;   // 0 (false)

    return 0;
}
