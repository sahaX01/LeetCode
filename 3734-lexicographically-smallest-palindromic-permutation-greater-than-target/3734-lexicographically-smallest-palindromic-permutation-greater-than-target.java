class Solution {

    StringBuilder result;
    int halfLen;
    char middle = 0;

    public boolean solve(StringBuilder curr, String target, int freq[], int i, boolean isGreater) {
        if (curr.length() == halfLen) {

            StringBuilder temp = new StringBuilder(curr); // left half
            if (middle != 0) {
                temp.append(middle); // if odd add middle
            }
            temp.append(new StringBuilder(curr).reverse()); // righthalf

            if (temp.toString().compareTo(target) > 0) {
                result = new StringBuilder(temp);
                return true;
            }

            return false;

        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int idx = ch - 'a';
            if (freq[idx] == 0)
                continue;

            if (!isGreater && ch < target.charAt(i)) {
                continue;
            }

            freq[idx]--;
            curr.append(ch);

            boolean newGreater = isGreater || ch > target.charAt(i);
            if (solve(curr, target, freq, i + 1, newGreater)) {
                return true;
            }
            curr.deleteCharAt(curr.length() - 1);
            freq[idx]++;
        }

        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {
        int freq[] = new int[26];
        halfLen = s.length() / 2;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int odd = 0;
        middle = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                middle = (char) ('a' + i);
            }
            freq[i] /= 2;
        }

        if (odd > 1) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        if(solve(ans, target, freq, 0, false)){
          return result.toString();
        }

        return "";
    }
}