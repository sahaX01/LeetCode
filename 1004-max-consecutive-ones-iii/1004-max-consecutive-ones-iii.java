class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int maxLen = 0;
        while(r < n){
          if(nums[r] == 0){
            k--;
          }
          while(k < 0){
            if(nums[l] == 0){
                k++;
            }
            l++;
          }
          
          
          maxLen = Math.max(maxLen, r - l + 1);
          r++;
        }

        return maxLen;
    }
}