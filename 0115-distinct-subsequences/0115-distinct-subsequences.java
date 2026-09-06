class Solution {
    Long dp[][];
    public long solve(String s, String t, int i, int j) {
        // t length is completed
        if (j == t.length()) {
            return 1;
        }
        // s length is completed but t length exist
        if (i == s.length()) {
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = solve(s, t, i + 1, j + 1) + solve(s, t, i + 1, j);
        }else{
            dp[i][j] = solve(s, t, i + 1, j);
        }
        
        return dp[i][j];

    }

    public int numDistinct(String s, String t) {
        dp = new Long[1001][1001];
        return (int) solve(s, t, 0, 0);
    }
}