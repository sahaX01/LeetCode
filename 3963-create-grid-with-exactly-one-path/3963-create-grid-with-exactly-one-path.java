class Solution {
    public String[] createGrid(int m, int n) {
        int row = m;
        int col = n;

        char[][] arr = new char[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = '#';
            }
        }

        for(int j=0; j<col; j++){
            arr[0][j] = '.';
        }

        for(int i=1; i<row; i++){
            arr[i][col-1] = '.';
        }

        String ans[] = new String[m];
        
        for(int i=0; i<row; i++){
            String s = new String("");
            for(int j=0; j<col; j++){
                s = s+arr[i][j];
            }
            ans[i] = s;
        }
        return ans;
    }
}