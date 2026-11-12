class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        int count = 1;
        for(int i=1; i<nums.length; i++){
          if(nums[i] > nums[i-1]){
            count++;
          }else{
            leftMax = Math.max(leftMax, count);
            count = 1;
          }
        }
        leftMax = Math.max(leftMax, count);
        for(int i=nums.length-2; i>=0; i--){
          if(nums[i] > nums[i+1]){
            count++;
          }else{
            rightMax = Math.max(rightMax, count);
            count = 1;
          }
        }
        rightMax = Math.max(rightMax, count);

        return Math.max(leftMax, rightMax);
    }
}