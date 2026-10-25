class Solution {
    static int m,n;
    public static boolean dfs(int [][] grid, int r, int c){
        if(r >= m || r < 0 || c >= n || c < 0){
            return false; // closed nahi hain
        }
        if(grid[r][c] == 1){
            return true; // is side se closed hain
        }
        grid[r][c] = 1; // marked visited
        boolean leftbound = dfs(grid, r, c-1);
        boolean rightbound = dfs(grid, r, c+1);
        boolean upbound = dfs(grid, r-1, c);
        boolean downbound = dfs(grid, r+1, c);

        return leftbound && rightbound && upbound && downbound;
    }
    public int closedIsland(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
         int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0 && dfs(grid, i, j) == true){
                    count++;
                }
            }
        }
        return count;
    }
}