class Solution {

    // Counts subarrays having AT MOST k odd numbers
    public static int find(int nums[], int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int count = 0;  // Number of odd elements in current window
        int ans = 0;    // Total valid subarrays

        // If k is negative, no valid subarray is possible
        if (k < 0) return 0;

        while (r < n) {

            // Expand the window by including nums[r]
            // If the current element is odd, increase odd count
            if (nums[r] % 2 != 0) {
                count++;
            }

            // Shrink the window until odd count becomes <= k
            while (count > k) {

                // If the leftmost element is odd, decrease odd count
                if (nums[l] % 2 != 0) {
                    count--;
                }

                l++; 
            }

            // Every subarray ending at r and starting from l to r
            // Number of such subarrays = r - l + 1
            ans += r - l + 1;

            r++; 
        }

        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        // Exactly k odd numbers =
        // At most k odd numbers - At most (k-1) odd numbers
        return find(nums, k) - find(nums, k - 1);
    }
}