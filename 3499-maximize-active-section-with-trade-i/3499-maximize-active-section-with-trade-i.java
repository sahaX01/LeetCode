class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        // Add '1' at both ends as mentioned in the problem
        String t = "1" + s + "1";
        int n = t.length();

        // Count the total number of active sections initially
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '1')
                ones++;
        }

        // Initially answer is the current number of ones
        int ans = ones;

        int i = 1;

        // Traverse the augmented string excluding added boundary 1s
        while (i < n - 1) {

            char ch = t.charAt(i);

            // Find a continuous block of 1s
            if (ch == '1') {

                int start = i;

                // Move i till the end of this 1 block
                while (i < n - 1 && t.charAt(i) == '1') {
                    i++;
                }

                int end = i - 1;

                // This 1 block can be traded only if it is surrounded by 0s
                if (t.charAt(start - 1) == '0' && t.charAt(end + 1) == '0') {

                    // Count consecutive zeros on the left side
                    int leftZero = 0;
                    int left = start - 1;

                    while (left > 0 && t.charAt(left) == '0') {
                        leftZero++;
                        left--;
                    }

                    // Count consecutive zeros on the right side
                    int rightZero = 0;
                    int right = end + 1;

                    while (right < n - 1 && t.charAt(right) == '0') {
                        rightZero++;
                        right++;
                    }

                    // Update answer using the available zero sections
                    ans = Math.max(ans, ones + leftZero + rightZero);
                }

            } else {

                // If current character is 0, move to next position
                i++;
            }
        }

        return ans;
    }
}