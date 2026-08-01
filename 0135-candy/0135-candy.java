class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candy[] = new int[n];
       
        Arrays.fill(candy, 1);
        
        // left to right
        for(int i=1; i<n; i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }
        
        // right to left
        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candy[i] = Math.max(candy[i],candy[i+1] + 1);
            }
        }
        int ans = 0;
        for(int c : candy){
            ans = ans + c;
        }

        return ans;
    }
}