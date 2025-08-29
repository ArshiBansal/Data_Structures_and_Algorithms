//Maximum XOR of two numbers in an array

#include <bits/stdc++.h>
using namespace std;

struct TrieNode {
    TrieNode* children[2] = {nullptr};
};

class Trie {
public:
    TrieNode* root = new TrieNode();

    void insert(int num) {
        TrieNode* node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node->children[bit])
                node->children[bit] = new TrieNode();
            node = node->children[bit];
        }
    }

    int maxXOR(int num) {
        TrieNode* node = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node->children[1 - bit]) {
                ans |= (1 << i);
                node = node->children[1 - bit];
            } else {
                node = node->children[bit];
            }
        }
        return ans;
    }
};

int findMaximumXOR(vector<int>& nums) {
    Trie trie;
    int res = 0;
    for (int num : nums) trie.insert(num);
    for (int num : nums) res = max(res, trie.maxXOR(num));
    return res;
}

int main() {
    vector<int> nums = {3,10,5,25,2,8};
    cout << findMaximumXOR(nums) << endl; // 28
}
