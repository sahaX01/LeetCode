class Solution {
    public int climbStairs(int n, int[] costs) {
        
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = costs[0] + 1;
        if(n == 1){
            return dp[1];
        }
        dp[2] = Math.min((costs[1] + 4), (dp[1]+costs[1]+1));
        if(n == 2){
            return dp[2];
        }
        
        for(int j=3; j<n+1; j++){
            dp[j] = Integer.MAX_VALUE;
          for(int i=j-1; i>=j-3; i--){
           dp[j] = Math.min(dp[j], dp[i] + costs[j-1] + (j - i) * (j - i));
          }
        }

        return dp[n];
    }
}