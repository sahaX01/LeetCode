class Solution {
    StringBuilder result = new StringBuilder();

    // Recursive backtracking function
    public boolean solve(StringBuilder curr, String target,
                         boolean greater, int i, int freq[]) {

        // If complete permutation is formed
        if (i == target.length()) {

            // Accept only if permutation is strictly greater than target
            if (greater) {
                result = new StringBuilder(curr);
                return true;
            }

            return false;
        }

        // Try characters from 'a' to 'z'
        // This ensures lexicographically smallest answer
        for (char ch = 'a'; ch <= 'z'; ch++) {

            // Character is not available
            if (freq[ch - 'a'] == 0)
                continue;

            // If we are still equal to target,
            // we cannot choose a smaller character
            if (!greater && ch < target.charAt(i))
                continue;

            // Once a greater character is chosen,
            // the complete string will remain greater
            boolean isGreater = greater || ch > target.charAt(i);

            // Choose current character
            curr.append(ch);
            freq[ch - 'a']--;

            // Recursively build the remaining characters
            if (solve(curr, target, isGreater, i + 1, freq)) {
                return true;
            }

            // Backtrack
            curr.deleteCharAt(curr.length() - 1);
            freq[ch - 'a']++;
        }

        return false;
    }

    public String lexGreaterPermutation(String s, String target) {

        // Frequency array for characters in s
        int freq[] = new int[26];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        // Current permutation being built
        StringBuilder curr = new StringBuilder();

        // Start recursion
        solve(curr, target, false, 0, freq);

        // Return smallest lexicographically greater permutation
        return result.toString();
    }
}