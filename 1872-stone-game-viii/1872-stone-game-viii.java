class Solution {
    Integer dp[];
    public int solve(int i, int prefixsum[]) {
        int n = prefixsum.length;
        if(dp[i] != null){
            return dp[i];
        }
        if (i == n - 1) {
            return prefixsum[n - 1];
        }

        int take = prefixsum[i] - solve(i + 1, prefixsum);
        int skip = solve(i + 1, prefixsum);

        return dp[i] = Math.max(take, skip);
    }

    public int stoneGameVIII(int[] stones) {
        int prefixsum[] = new int[stones.length];
        dp = new Integer[100001];
        prefixsum[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + stones[i];
        }

        return solve(1, prefixsum);
    }
}