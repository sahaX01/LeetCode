class Solution {
    Integer dp[][];
    public static boolean isPalindrome(String s, int l, int r){
        
        while(l<r){
          if(s.charAt(l) != s.charAt(r)){
            return false;
          }
          l++;
          r--;
        }

        return true;
    }
    public  int solve(String s, int k, int i, int j){
        int n = s.length();

        if(k == 1) return n;
        if(i>=n || j>=n || i>j) return 0;
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(isPalindrome(s, i, j)){
            int takeIt = 1 + solve(s, k, j+1, j+k);
            int grow = solve(s, k, i, j+1);
            int slide = solve(s, k, i+1, j+1);

            return dp[i][j] = Math.max(takeIt, Math.max(grow, slide));
        }

           int grow = solve(s, k, i, j+1);
           int slide = solve(s, k, i+1, j+1);
           return dp[i][j] = Math.max(grow, slide);
 
    }
    public int maxPalindromes(String s, int k) {
        dp = new Integer[2001][2001];
        return solve(s, k, 0, k-1);
    }
}

// TC : O(n^3)
// SC : O(n^2)