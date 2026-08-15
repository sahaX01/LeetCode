class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;

        int n = nums.length;
        for (int num : nums) {
            xor = xor ^ num;
        }
        boolean allzero = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                allzero = false;
            }
        }

        if (allzero)
            return 0;
        if (xor != 0) {
            return nums.length;
        }

        return nums.length - 1;

    }
}