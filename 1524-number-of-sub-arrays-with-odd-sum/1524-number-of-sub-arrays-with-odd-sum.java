class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int odd = 0, even = 1;
        int prefix = 0, ans = 0;

        for (int x : arr) {
            prefix += x;

            if (prefix % 2 == 0) {
                ans = (ans + odd) % mod;
                even++;
            } else {
                ans = (ans + even) % mod;
                odd++;
            }
        }

        return ans;
    }
}