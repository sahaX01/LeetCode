class Solution {

    public long GCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public long LCM(long a, long b) {
        return (a / GCD(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            long mul = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < nums.length; j++) {
                mul = mul * nums[j];
                gcd = GCD(gcd, nums[j]);
                lcm = LCM(lcm, nums[j]);
                if (mul == (gcd * lcm)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }

        }
        return ans;
    }

}