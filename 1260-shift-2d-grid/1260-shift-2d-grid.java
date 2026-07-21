class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;
        k = k % total;
        
        int res[][] = new int[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
             int oldIndex = r * n + c;
             int newIndex = (oldIndex + k) % total;
             int newRow = newIndex / n;
             int newCol = newIndex % n;
             res[newRow][newCol] = grid[r][c];
            }
        }
        

        List<List<Integer>> ll = new ArrayList<>();

        for(int i=0; i<m; i++){
            List<Integer> ans = new ArrayList<>();
            for(int j=0; j<n; j++){
               ans.add(res[i][j]);
            }
            ll.add(ans);
        }

        return ll;
    }
}