class Solution {
    static Integer[][][] dp;
    public static int solveForAlice(int[] piles, int person, int i, int M){
      int n = piles.length;
      if(i>=n) return 0;
      if(dp[person][i][M] != null){
        return dp[person][i][M];
      }
      int stones = 0;
      int result = -1;
      if(person == 1){
        result = Integer.MIN_VALUE;
      }else{
        result = Integer.MAX_VALUE;
      }

      for(int x=1; x<=Math.min(2*M,n-i); x++){
        stones = stones + piles[i+x-1];
        if(person == 1){ // Alice
          result = Math.max(result, stones+solveForAlice(piles, 0, i+x, Math.max(M,x)));
        }else{ // Bob
          result = Math.min(result, solveForAlice(piles, 1, i+x, Math.max(M,x)));
        }
      }

      return dp[person][i][M] = result;
    }
    public int stoneGameII(int[] piles) {
        dp = new Integer[2][101][101];
       return solveForAlice(piles, 1, 0, 1);
    }
}