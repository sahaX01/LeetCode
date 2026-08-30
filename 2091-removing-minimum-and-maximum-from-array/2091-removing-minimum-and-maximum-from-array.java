class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mxleft = 0;
        int mxright = 0;
        
        int mnleft = 0;
        int mnright = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                mxleft = i + 1;
                mxright = n - i;
                
            }
            if (nums[i] < min) {
                min = nums[i];
                mnleft = i + 1;
                mnright = n - i;
               
            }
        }
        
        int ans = 0;
        return Math.min(
                Math.min(Math.max(mxleft, mnleft),
                        Math.max(mxright, mnright)),
                Math.min(mxleft + mnright,
                        mnleft + mxright));

    }
}