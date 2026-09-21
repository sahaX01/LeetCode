import java.util.*;

class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            // next will contain subarrays ending at current index
            long[] next = new long[k];

            // 1. Start a new subarray with only 'num'
            int rem = num % k;
            next[rem]++;

            // 2. Extend every previous subarray by 'num'
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                // Previous product % k = r
                // New product % k = (r * num) % k
                int newRem = (int) ((long) r * rem % k);

                next[newRem] += dp[r];
            }

            // All subarrays ending at current index
            // become the previous subarrays for the next iteration
            dp = next;

            // Add their counts to the final answer
            for (int r = 0; r < k; r++) {
                ans[r] += dp[r];
            }
        }

        return ans;
    }
}