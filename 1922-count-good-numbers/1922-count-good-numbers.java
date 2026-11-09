class Solution {
    static int MOD = (int) 1e9 + 7;

    public static int power(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long halfPower = power(a, b / 2);
        long power = (halfPower * halfPower) % MOD;
        if (b % 2 != 0) {
            return (int)((a * power) % MOD);
        }

        return (int)power % MOD;
    }

    public int countGoodNumbers(long n) {
        long evenIndices = (n + 1) / 2;
        long oddIndices = n / 2;

        int powera = power(5, evenIndices);
        int powerb = power(4, oddIndices);

        return (int) ((1L * powera * powerb) % MOD);
    }
}