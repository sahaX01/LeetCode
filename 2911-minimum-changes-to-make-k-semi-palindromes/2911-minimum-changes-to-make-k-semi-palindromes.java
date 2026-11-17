class Solution {
    String str;
    int n;
    Integer[][] dp;

    public int getCost(int i, int j) {
        int len = j - i + 1;
        int minCost = Integer.MAX_VALUE;
        for (int d = 1; d < len; d++) {
            if (len % d != 0)
                continue;
            int cost = 0;
            for (int group = 0; group < d; group++) {
                int l = i + group;
                int r = l + (len / d - 1) * d;

                while (l < r) {
                    if (str.charAt(l) != str.charAt(r)) {
                        cost++;
                    }
                    l = l + d;
                    r = r - d;
                }
            }
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    public int solve(int start, int k) {
        if (k == 0) {
            if (start == n) {
                return 0;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (start + 2 * k > n) {
            return Integer.MAX_VALUE;
        }

        if (dp[start][k] != null) {
            return dp[start][k];
        }
        int minCost = Integer.MAX_VALUE;
        for (int end = start + 1; end < n; end++) {

            int remainCost = solve(end + 1, k - 1);

            if (remainCost == Integer.MAX_VALUE)
                continue;
            minCost = Math.min(minCost, getCost(start, end) + remainCost);
        }
        dp[start][k] = minCost;
        return dp[start][k];
    }

    public int minimumChanges(String s, int k) {
        str = s;
        n = s.length();
        dp = new Integer[n + 1][k + 1];
        return solve(0, k);
    }
}