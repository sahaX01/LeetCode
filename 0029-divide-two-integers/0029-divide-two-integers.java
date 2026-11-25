class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        boolean sign = true; // +ve

        if (dividend >= 0 && divisor < 0) {
            sign = false; // -ve
        }
        if (dividend < 0 && divisor > 0) {
            sign = false; // -ve
        }

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;
        while (n >= d) {
            long count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans = ans + (1L << count);
            n = n - (d << count);
        }

        if (ans > Integer.MAX_VALUE && sign == true) {
            return Integer.MAX_VALUE;
        }
        if (ans > 2147483648L && !sign)
            return Integer.MIN_VALUE;
        return sign ? (int) ans : (int) (-ans);
    }
}