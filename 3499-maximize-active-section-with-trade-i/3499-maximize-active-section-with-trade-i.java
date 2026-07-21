class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int n = t.length();

        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1')
                ones++;
        }

        int ans = ones;

        int i = 1;
        while (i < n - 1) {
            char ch = t.charAt(i);

            if (ch == '1') {
                int start = i;
                while (i < n - 1 && t.charAt(i) == '1') {
                    i++;
                }
                int end = i - 1;

                if (t.charAt(start - 1) == '0' && t.charAt(end + 1) == '0') {

                    int leftZero = 0;
                    int left = start - 1;

                    while (left > 0 && t.charAt(left) == '0') {
                        leftZero++;
                        left--;
                    }
                    int rightZero = 0;
                    int right = end + 1;
                    while (right < n - 1 && t.charAt(right) == '0') {
                        rightZero++;
                        right++;
                    }
                    ans = Math.max(ans, ones + leftZero + rightZero);
                }

            } else {
                i++;
            }
        }

        return ans;
    }
}