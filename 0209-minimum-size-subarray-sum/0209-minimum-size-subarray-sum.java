class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
    
        for(; r<nums.length; r++){
          sum = sum + nums[r];
          while(sum>=target){ 
            ans = Math.min(ans, r-l+1);
            sum = sum - nums[l];
            l++;
          }
          
        }
        
        if(ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}