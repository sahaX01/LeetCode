class Solution {
    static Boolean dp[];
    public static boolean solve(int n){
        
        if(n == 0) return false;
        if(dp[n] != null){
            return dp[n];
        }
        for(int i=1; i * i<=n; i++){
          
          int squre = i * i;
          if(solve(n-squre) == false){
            return dp[n] = true;
          }
        }

        return dp[n] = false;
    }
    public boolean winnerSquareGame(int n) {
       dp = new Boolean[n+1];
       return solve(n);
    }
}