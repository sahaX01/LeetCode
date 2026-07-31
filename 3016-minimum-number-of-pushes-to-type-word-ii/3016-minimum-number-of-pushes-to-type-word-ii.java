import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies in ascending order
        Arrays.sort(freq);

        int ans = 0;
        int idx = 0;

        // Traverse from largest frequency to smallest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }

            ans += freq[i] * ((idx / 8) + 1);
            idx++;
        }

        return ans;
    }
}