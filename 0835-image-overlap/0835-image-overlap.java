class Solution {
    public int countOverlap(int[][] img1, int[][] img2, int rowOffset, int colOffset){
        int count = 0;
      for(int i=0; i<img1.length; i++){
        for(int j=0; j<img1.length; j++){
            int newi = i + rowOffset;
            int newj = j + colOffset;

            if(newi<0 || newi>= img1.length || newj<0 || newj>=img1.length){
                continue;
            }
            if(img1[newi][newj] == 1 && img2[i][j] == 1){
                count++;
            }
        }
      }
      return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxoverlaps = Integer.MIN_VALUE;
        for(int rowOffset = -n+1; rowOffset<n; rowOffset++){
            for(int colOffset = -n+1; colOffset<n; colOffset++){
             int cnt = countOverlap(img1, img2, rowOffset, colOffset);
             maxoverlaps = Math.max(cnt, maxoverlaps);
            }
        }

        return maxoverlaps;
    }
}