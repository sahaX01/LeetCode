class Solution {
    static int m, n;

    public static long solve(int grid[][], int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0;
        }
        if (grid[r][c] == 0) {
            return 0;
        }
        long sum = 0;

        long currsum = grid[r][c];
        grid[r][c] = 0;
        long lsum = solve(grid, r, c - 1);
        long rsum = solve(grid, r, c + 1);
        long usum = solve(grid, r - 1, c);
        long dsum = solve(grid, r + 1, c);
        sum = currsum + lsum + rsum + usum + dsum;

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    long landsum = solve(grid, i, j);
                    if (landsum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}