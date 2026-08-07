import java.util.*;

class Solution {

    // Creates the smallest possible number of length 'len'
    // whose digit product contains the required factor
    String freeSlotFiller(long required, long len) {

        // Stores generated digits
        StringBuilder sb = new StringBuilder();

        // Try digits from 9 to 2 because larger digits
        // contain more prime factors
        for (int digit = 9; digit >= 2; digit--) {

            // Keep adding this digit while it divides required
            while (required % digit == 0) {

                // Convert integer digit into character and add
                sb.append((char) (digit + '0'));

                // Remove this digit contribution from required
                required /= digit;
            }
        }

        // Fill remaining positions with 1
        // because 1 does not affect product
        while (sb.length() < len) {

            sb.append('1');
        }

        // Reverse because we added bigger digits first
        // to get smallest possible arrangement
        return sb.reverse().toString();
    }

    // Finds greatest common divisor using Euclidean algorithm
    long gcd(long a, long b) {

        // Continue until remainder becomes zero
        while (b != 0) {

            // Store remainder
            long temp = a % b;

            // Move b into a
            a = b;

            // Move remainder into b
            b = temp;
        }

        // a contains gcd
        return a;
    }

    public String smallestNumber(String num, long t) {

        // Length of given number
        int n = num.length();

        // Copy t because we will modify it
        long temp = t;

        // Only these prime factors can be created by digits
        int primeFactors[] = { 2, 3, 5, 7 };

        // Remove all possible factors 2,3,5,7 from t
        for (int primeFact : primeFactors) {

            // Divide while this prime factor exists
            while (temp % primeFact == 0) {

                temp /= primeFact;
            }
        }

        // If any other prime factor remains,
        // no digit product can satisfy it
        if (temp != 1) {

            return "-1";
        }

        // remainingFactor[i] stores:
        // after taking first i digits,
        // what factor is still needed
        long[] remainingFactor = new long[n + 1];

        // Initially every position needs complete t
        Arrays.fill(remainingFactor, t);

        // Calculate remaining factors for every prefix
        for (int i = 0; i < n; i++) {

            // Convert character digit into integer
            int digit = num.charAt(i) - '0';

            // If zero appears, prefix cannot be continued
            if (digit == 0)
                break;

            // Remove common factors of current digit
            // from remaining required factor
            remainingFactor[i + 1] = remainingFactor[i] /
                    gcd(remainingFactor[i], (long) digit);
        }

        // If original number already satisfies condition
        // return it
        if (remainingFactor[n] == 1) {

            return num;
        }

        // Find position of first zero
        int zeroPos = num.indexOf('0');

        // Assume last digit needs modification
        int zeroIdx = n - 1;

        // If zero exists, we cannot keep digits after it
        if (zeroPos != -1) {

            zeroIdx = zeroPos;
        }

        // Try modifying digits from right to left
        for (int i = zeroIdx; i >= 0; i--) {

            // Required factor after taking prefix before i
            long required = remainingFactor[i];

            // Number of positions available after current digit
            long freeSlots = n - 1 - i;

            // Try every larger digit
            // because answer must be >= num
            for (int digit = num.charAt(i) - '0' + 1; digit <= 9; digit++) {

                // Remove factor contribution of chosen digit
                long furtherRequired = required /
                        gcd(required, digit);

                // Build the smallest suffix
                // using remaining positions
                String requiredNumber = freeSlotFiller(
                        furtherRequired,
                        freeSlots);

                // If suffix length matches available slots,
                // we found valid answer
                if (requiredNumber.length() == freeSlots) {

                    // Keep prefix same
                    // Increase current digit
                    // Add smallest suffix
                    return num.substring(0, i)
                            + (char) (digit + '0')
                            + requiredNumber;
                }
            }
        }

        // If no answer with same length,
        // try a number with length n+1
        return freeSlotFiller(t, n + 1);
    }
}