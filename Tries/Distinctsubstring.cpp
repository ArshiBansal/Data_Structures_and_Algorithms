#include <bits/stdc++.h>
using namespace std;

struct TrieNode {
    TrieNode* children[26] = {nullptr};
};

int countDistinctSubstrings(string s) {
    TrieNode* root = new TrieNode();
    int count = 0;

    for (int i = 0; i < s.size(); i++) {
        TrieNode* node = root;
        for (int j = i; j < s.size(); j++) {
            int idx = s[j] - 'a';
            if (!node->children[idx]) {
                node->children[idx] = new TrieNode();
                count++;
            }
            node = node->children[idx];
        }
    }
    return count;
}

int main() {
    string s = "ababa";
    cout << countDistinctSubstrings(s) << endl; // 9
}
