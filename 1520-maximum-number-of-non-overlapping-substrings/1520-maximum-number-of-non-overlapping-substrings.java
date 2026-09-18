import java.util.*;

class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // First and last occurrence of each character
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1) {
                first[ch] = i;
            }

            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Find the smallest valid interval starting
        // from the first occurrence of every character
        for (int c = 0; c < 26; c++) {

            if (first[c] == -1) {
                continue;
            }

            int l = first[c];
            int r = last[c];

            boolean valid = true;

            for (int i = l; i <= r; i++) {

                int ch = s.charAt(i) - 'a';

                // This character appeared before l,
                // so we cannot make a valid substring
                if (first[ch] < l) {
                    valid = false;
                    break;
                }

                // Need to include all occurrences
                r = Math.max(r, last[ch]);
            }

            if (valid) {
                intervals.add(new int[]{l, r});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals) {

            int l = interval[0];
            int r = interval[1];

            // Non-overlapping
            if (l > prevEnd) {

                ans.add(s.substring(l, r + 1));

                prevEnd = r;
            }
        }

        return ans;
    }
}