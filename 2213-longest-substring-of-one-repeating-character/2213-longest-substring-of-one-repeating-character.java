import java.util.*;

class Solution {

    static class Node {
        int leftChar, rightChar;
        int leftLen, rightLen;
        int maxLen;
        int len;

        Node(int c) {
            leftChar = rightChar = c;
            leftLen = rightLen = maxLen = len = 1;
        }

        Node() {
            len = 0;
        }
    }

    static Node[] tree;

    // Merge two nodes
    static Node merge(Node a, Node b) {

        if (a.len == 0) return b;
        if (b.len == 0) return a;

        Node res = new Node();
        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        // Left prefix
        res.leftLen = a.leftLen;

        if (a.leftLen == a.len && a.rightChar == b.leftChar) {
            res.leftLen = a.len + b.leftLen;
        }

        // Right suffix
        res.rightLen = b.rightLen;

        if (b.rightLen == b.len && a.rightChar == b.leftChar) {
            res.rightLen = b.len + a.rightLen;
        }

        // Maximum inside left/right
        res.maxLen = Math.max(a.maxLen, b.maxLen);

        // Join suffix of a + prefix of b
        if (a.rightChar == b.leftChar) {
            res.maxLen = Math.max(
                res.maxLen,
                a.rightLen + b.leftLen
            );
        }

        return res;
    }

    static void build(char[] s, int idx, int l, int r) {

        if (l == r) {
            tree[idx] = new Node(s[l] - 'a');
            return;
        }

        int mid = (l + r) / 2;

        build(s, idx * 2, l, mid);
        build(s, idx * 2 + 1, mid + 1, r);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    static void update(int idx, int l, int r, int pos, int ch) {

        if (l == r) {
            tree[idx] = new Node(ch);
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(idx * 2, l, mid, pos, ch);
        } else {
            update(idx * 2 + 1, mid + 1, r, pos, ch);
        }

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();
        int k = queryIndices.length;

        tree = new Node[4 * n];

        char[] arr = s.toCharArray();

        // Build segment tree
        build(arr, 1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Update character
            update(1, 0, n - 1, index, ch - 'a');

            // Root contains answer for whole string
            ans[i] = tree[1].maxLen;
        }

        return ans;
    }
}