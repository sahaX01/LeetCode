class Solution {
    int m; // rows
    int n; // cols
    int MOD = 1000000007;
    int LEFT = 0; // Arrived at current cell from left cell (it means it was moving right)
    int UP = 1; // Arrived at current cell from up cell (it means it was moving down)
    Integer dp[][][];
    public int solve(int grid[][], int i, int j, int cameFrom){
     if(i >= m || j >= n){
        return 0;
     }
     if(i == m-1 && j == n-1){
        return 1;
     }
     if(dp[i][j][cameFrom] != null){
        return dp[i][j][cameFrom];
     }

     if(grid[i][j] == 0){
        dp[i][j][cameFrom] = (solve(grid, i+1, j, UP) + solve(grid, i, j+1, LEFT)) % MOD;
     }else{ // mirror
        if(cameFrom == UP){
            dp[i][j][cameFrom] = solve(grid, i, j+1, LEFT);
        }else{
            dp[i][j][cameFrom] = solve(grid, i+1, j, UP);
        }
     }

     return dp[i][j][cameFrom];
    }
    public int uniquePaths(int[][] grid) {
        
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n][2];
        return solve(grid, 0, 0, LEFT);
    }
}