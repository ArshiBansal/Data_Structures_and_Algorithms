//	Maximum XOR With an Element From Array

import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

class Trie {
    TrieNode root = new TrieNode();

    // Insert binary representation of number
    void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }

    // Find maximum XOR with given number
    int maxXOR(int num) {
        TrieNode node = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[1 - bit] != null) {
                ans |= (1 << i);
                node = node.children[1 - bit];
            } else if (node.children[bit] != null) {
                node = node.children[bit];
            } else {
                return -1; // Trie is empty
            }
        }
        return ans;
    }
}

public class MaximumXOR {
    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        int[] ans = new int[n];

        // Augment queries with original index
        int[][] q = new int[n][3];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i][0]; // x
            q[i][1] = queries[i][1]; // m
            q[i][2] = i;             // original index
        }

        Arrays.sort(q, (a,b) -> Integer.compare(a[1], b[1])); // sort by m

        Trie trie = new Trie();
        int idx = 0;

        for (int[] query : q) {
            int x = query[0], m = query[1], qIdx = query[2];
            // Insert all nums ≤ m
            while (idx < nums.length && nums[idx] <= m) {
                trie.insert(nums[idx]);
                idx++;
            }
            if (idx == 0) ans[qIdx] = -1; // no valid numbers
            else ans[qIdx] = trie.maxXOR(x);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[][] queries = {{3,1},{1,3},{5,6}};
        int[] ans = maximizeXor(nums, queries);
        System.out.println(Arrays.toString(ans)); // [3,3,7]
    }
}
