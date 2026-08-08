class Solution {
    public int[] validSequence(String word1, String word2) {

        // Length of word1
        int n = word1.length();

        // Length of word2
        int m = word2.length();

        /*
         * result[j] stores the index in word1 where
         * word2[j] can be matched while matching
         * word2 from RIGHT to LEFT.
         *
         * This helps us know whether the remaining
         * characters of word2 can be matched after
         * using one character as a mismatch.
         */
        int result[] = new int[m];

        // Initially, no position is found
        Arrays.fill(result, -1);

        // Start from the end of both strings
        int i = n - 1;
        int j = m - 1;

        /*
         * Build the result array from RIGHT to LEFT.
         *
         * We greedily find the latest possible positions
         * in word1 for the characters of word2.
         */
        while (i >= 0 && j >= 0) {

            // If current characters match
            if (word1.charAt(i) == word2.charAt(j)) {

                // Store the position of this match
                result[j] = i;

                // Move to the previous character of word2
                j--;
            }

            // Always move left in word1
            i--;
        }

        /*
         * Now construct the final answer from
         * LEFT to RIGHT.
         */
        i = 0;
        j = 0;

        // We are allowed to use at most ONE mismatch
        boolean isUsed = false;

        // Stores the selected indices of word1
        int ans[] = new int[m];

        // Initially, no index has been selected
        Arrays.fill(ans, -1);

        /*
         * Traverse word1 from left to right and
         * try to construct word2.
         */
        while (i < n && j < m) {

            /*
             * CASE 1:
             * Current characters are equal.
             *
             * We can directly use word1[i]
             * for word2[j].
             */
            if (word1.charAt(i) == word2.charAt(j)) {

                // Store the selected index
                ans[j] = i;

                // Move to the next character of word2
                j++;

            } else {

                /*
                 * CASE 2:
                 * Current characters are different.
                 *
                 * We can use this position as our
                 * ONE allowed mismatch.
                 *
                 * But before using it, we must make sure
                 * that the remaining characters of word2
                 * can still be matched after i.
                 */
                if (!isUsed &&
                    (j == m - 1 || i + 1 <= result[j + 1])) {

                    // Use word1[i] as the mismatch
                    ans[j] = i;

                    // Mark that the mismatch has been used
                    isUsed = true;

                    // Move to the next character of word2
                    j++;
                }
            }

            // Always move forward in word1
            i++;
        }

        /*
         * If j reached m, it means all characters
         * of word2 were successfully matched.
         *
         * Otherwise, a valid sequence was not found.
         */
        return j == m ? ans : new int[0];
    }
}