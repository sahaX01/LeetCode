class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        
        // 1st , 2nd smallest change
        int val1 = nums[n-1] - nums[2];
        // 1st , 2nd highest change
        int val2 = nums[n-3] - nums[0];
        // smallest and largest change
        int val3 = nums[n-2] - nums[1];
        return Math.min(Math.min(val1, val2) , val3);
    }
}