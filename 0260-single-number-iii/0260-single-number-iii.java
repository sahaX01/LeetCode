
class Solution {
    public int[] singleNumber(int[] nums) {

        long xor = 0;

        // Step 1: XOR all elements.
        // Duplicate numbers cancel each other.
        // Remaining XOR = num1 ^ num2
        for (int x : nums) {
            xor = xor ^ x;
        }

        long b1 = 0;
        long b2 = 0;

        // Step 2: Find the rightmost set bit.
        // This bit is different in the two unique numbers.
        long rightMost = xor & (xor - 1) ^ xor;

        // Step 3: Divide numbers into two groups
        // Group 1: Numbers having the rightmost bit set.
        // Group 2: Numbers having the rightmost bit unset.
        for (int x : nums) {

            if ((rightMost & x) != 0) {
                b1 = b1 ^ x; // Find first unique number
            } else {
                b2 = b2 ^ x; // Find second unique number
            }
        }

        // Step 4: Return both unique numbers.
        return new int[]{(int)b1, (int)b2};
    }
}
