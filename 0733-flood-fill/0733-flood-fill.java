class Solution {
    public void solve(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol){
       
       if(sr < 0 || sc < 0 || sr>=image.length || sc >= image[0].length || vis[sr][sc] 
       || image[sr][sc] != orgCol){
        return;
       }
       vis[sr][sc] = true;
       image[sr][sc] = color;
       solve(image, sr, sc+1, color, vis, orgCol);
       solve(image, sr, sc-1, color, vis, orgCol);
       solve(image, sr+1, sc, color, vis, orgCol);
       solve(image, sr-1, sc, color, vis, orgCol);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        
        int orgCol = image[sr][sc];
        if(orgCol == color){
            return image;
        }
        solve(image, sr, sc, color, vis, orgCol);

        return image;
    }
}