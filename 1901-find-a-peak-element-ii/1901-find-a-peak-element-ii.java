class Solution {
    public static int findRowIndex(int mat[][], int r, int c, int col){
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for(int i=0; i<r; i++){
            int val = mat[i][col];
            if(val>max){
                max = val;
                idx = i;
            }
        }

        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int l = 0;
        int h = n-1;

        while(l<=h){
            int mid = (l+h)/2;
            int row = findRowIndex(mat, m, n, mid);

            int left = mid-1>=0 ? mat[row][mid-1] : -1;
            int right = mid+1<n ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && mat[row][mid]>right){
                return new int[]{row, mid};
            }else if(mat[row][mid] > right){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}