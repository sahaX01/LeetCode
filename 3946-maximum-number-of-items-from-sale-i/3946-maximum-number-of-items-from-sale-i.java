class Solution {

    Integer dp[][];

    public int solve(int n, int[][] items, int[] copies, int budget, int minPrice){
        if(n == 0){
            return budget/minPrice;
        }

        if(dp[n][budget] != null){
            return dp[n][budget]; 
        }

        int take = 0;
        int price = items[n-1][1];

        if(price <= budget){
            take = 1 + copies[n-1] + solve(n-1, items, copies, budget-price, minPrice);
        }

        int skip = solve(n-1, items, copies, budget, minPrice);

        return dp[n][budget] = Math.max(take, skip);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int copies[] = new int[items.length];
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        
        dp = new Integer[1001][1501];

        for(int i=0; i<n; i++){
            int copy = 0;
            minPrice = Math.min(minPrice, items[i][1]);
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(items[j][0] % items[i][0] == 0){
                    copy++;
                }
            }
            copies[i] = copy;
        }

        return solve(n, items, copies, budget, minPrice);
    }
}