class Solution {
    int prefix[];
    Integer dp[][];
    public  int solve(int l, int r){
        if(l==r) return 0;
        if(dp[l][r] != null){
            return dp[l][r];
        }
        int score = 0;
        // try every possible split
        for(int mid=l; mid<r; mid++){
           int leftsum = prefix[mid+1] - prefix[l];
           int rightsum = prefix[r+1] - prefix[mid+1];

           if(leftsum<rightsum){
            score = Math.max(score, leftsum+solve(l, mid));
           }else if(rightsum<leftsum){
            score = Math.max(score, rightsum+solve(mid+1, r));
           }else{
            score = Math.max(score, Math.max(leftsum+solve(l,mid), rightsum+solve(mid+1, r)));
           }
        }
        return dp[l][r] = score;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        prefix = new int[n+1];
        // prefix sum
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + stoneValue[i];
        }
        dp = new Integer[n+1][n+1];
       return solve(0, n-1);
    }
}