class Solution {
    Integer dp[];
    public int solve(int nums[], int i, int n){
        if(i == n) return 0;

        if(dp[i] != null){
            return dp[i];
        }
        int result = nums[i] - solve(nums, i+1, n);
        if(i+1<n){
          result = Math.max(result, nums[i]+nums[i+1] - solve(nums, i+2, n));
        }
        if(i+2<n){
          result = Math.max(result, nums[i]+nums[i+1]+nums[i+2] - solve(nums, i+3, n));
        }

        return dp[i] = result;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n];
        int result = solve(stoneValue, 0, n);

        if(result>0) return "Alice";
        else if(result<0) return "Bob";

        return "Tie";
    }
}