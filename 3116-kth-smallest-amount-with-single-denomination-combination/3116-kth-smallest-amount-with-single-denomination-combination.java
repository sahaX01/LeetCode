import java.util.*;

class Solution {

    public long findKthSmallest(int[] coins, int k) {

        // Minimum possible answer
        long low = 1;

        // Maximum answer can be k * smallest coin
        long high = (long) coins[0] * k;

        // Find the smallest coin
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        // Binary search for the kth smallest amount
        while (low < high) {

            long mid = low + (high - low) / 2;

            // Count how many valid amounts are <= mid
            if (count(mid, coins) >= k) {
                // There are already k amounts
                // Try to find a smaller answer
                high = mid;
            } else {
                // Not enough amounts
                // Need a bigger value
                low = mid + 1;
            }
        }

        // low is the smallest value having at least k amounts
        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        // Generate every non-empty subset of coins
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            // Find the LCM of the current subset
            for (int i = 0; i < n; i++) {

                // Check whether coin i is present in this subset
                if ((mask & (1 << i)) != 0) {

                    bits++;

                    // Calculate LCM
                    lcm = lcm(lcm, coins[i]);

                    // If LCM is already bigger than x,
                    // no multiple of it can be <= x
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            // Number of multiples of LCM <= x
            long value = x / lcm;

            // Odd number of coins in subset -> add
            if (bits % 2 == 1) {
                total += value;
            }

            // Even number of coins -> subtract
            // This is Inclusion-Exclusion
            else {
                total -= value;
            }
        }

        return total;
    }

    // Calculate GCD using Euclidean algorithm
    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    // Calculate LCM using:
    // LCM(a,b) = (a / GCD(a,b)) * b
    private long lcm(long a, long b) {

        return a / gcd(a, b) * b;
    }
}