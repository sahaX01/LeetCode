class Solution {
    Integer dp[][];

    public int solve(int[] piles, int i, int j){
        if(dp[i][j] != null) return dp[i][j];
        if(i == j) return piles[i];
        int left = piles[i] - solve(piles, i+1, j);
        int right = piles[j] - solve(piles, i, j-1);
        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];
        return solve(piles, 0, n-1)>=0;
    }
}