class Solution {

    Boolean[] dp;

    public boolean solve(int n) {

        // No move possible -> current player loses
        if (n == 0) return false;

        // Already calculated
        if (dp[n] != null) {
            return dp[n];
        }

        // Try every possible square
        for (int i = 1; i * i <= n; i++) {

            int square = i * i;

            // after alice move , If Bob no move bob losses
            // alice wins
            if (solve(n - square) == false) {
                return dp[n] = true;
            }
        }

        // No winning move found for alice
        return dp[n] = false;
    }

    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n + 1];

        return solve(n);
    }
}