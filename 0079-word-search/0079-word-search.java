
class Solution {

    // 4 directions: Down, Right, Up, Left
    int[][] a = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    int m, n;

    public boolean find(char[][] board, int i, int j, String word, int idx) {

        // All characters matched -> word found
        if (idx == word.length()) {
            return true;
        }

        // Boundary check + already visited check
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$') {
            return false;
        }

        // Current cell doesn't match the required character
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '$';

        // Explore all 4 adjacent directions
        for (int[] dir : a) {
            int newi = i + dir[0];
            int newj = j + dir[1];

            // Search for the next character
            if (find(board, newi, newj, word, idx + 1)) {
                board[i][j] = temp; // Restore before returning
                return true;
            }
        }

        // Backtrack: restore the original character
        board[i][j] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        // Try every cell as a possible starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // First character must match
                if (board[i][j] == word.charAt(0)) {

                    // Start DFS from this cell
                    if (find(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false; // Word not found
    }
}
