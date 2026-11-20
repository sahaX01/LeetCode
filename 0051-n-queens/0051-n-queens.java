class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] Board;
    public boolean isSafe(char[][] Board, int row, int col, int n) {
        // row
        for (int i = 0; i < n; i++) {
            if (Board[i][col] == 'Q') {
                return false;
            }
        }
        // column
        for (int j = 0; j < n; j++) {
            if (Board[row][j] == 'Q') {
                return false;
            }
        }
        // left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (Board[i][j] == 'Q') {
                return false;
            }
        }
        // right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (Board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void solve(int row, int n, char[][] Board) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(new String(Board[i]));
            }
            ans.add(temp);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(Board, row, j, n)) {
                Board[row][j] = 'Q';
                solve(row + 1, n, Board);
                Board[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        Board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(Board[i], '.');
        }
        
        solve(0, n, Board);

        return ans;
    }
}