class Solution {
    static Boolean dp[][];
    public static boolean solve(String str, int i, int j){
      if(i>=j){
        return true;
      }
      if(dp[i][j] != null){
        return dp[i][j];
      }
      if(str.charAt(i) == str.charAt(j)){
        return dp[i][j] = solve(str, i+1, j-1);
      }
        return dp[i][j] = false;
    }
    public String longestPalindrome(String s) {
        int n = s.length(); 
        dp = new Boolean[n][n];
        
        int maxLen = 0;
        int sp = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
              if(solve(s, i, j)){
                if(j-i+1 > maxLen){
                    maxLen = j-i+1;
                    sp = i;
                }
              }
            }
        }

        return s.substring(sp, sp+maxLen);
    }
}