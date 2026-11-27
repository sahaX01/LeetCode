
class Solution {

    // Counts subarrays having sum <= goal (AtMost)
    public static int find(int nums[], int goal) {

        // Negative goal is impossible for non-negative arrays
        if (goal < 0)
            return 0;

        int l = 0;
        int r = 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;

        while (r < n) {

            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            // All subarrays ending at r and starting from l to r
            // are valid: [l...r], [l+1...r], ..., [r...r]
            count += r - l + 1;

            // Move right pointer forward
            r++;
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        // Exactly(goal) = AtMost(goal) - AtMost(goal-1)
        return find(nums, goal) - find(nums, goal - 1);
    }
}
