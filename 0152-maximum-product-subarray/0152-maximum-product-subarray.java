class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int suf = 1;
        int pre = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(suf == 0) suf = 1;
            if(pre == 0) pre = 1;
            pre = pre * nums[i];
            suf = suf * nums[n-i-1];
            max = Math.max(max, Math.max(pre, suf));
        }
        return max;
    }
}