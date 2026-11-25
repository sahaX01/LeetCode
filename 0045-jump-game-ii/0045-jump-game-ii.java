class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0, r = 0;
        int n = nums.length;

        while (r < n - 1) {
            int farthest = 0;

            // Explore all indices reachable within the current jump range
            for (int i = l; i <= r; i++) {

                // Find the maximum index we can reach from the current range
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Next range starts just after the previous range
            l = r + 1;

            // Extend the range to the farthest reachable index
            r = farthest;

            // One jump is completed
            jumps++;
        }

        // Return the minimum number of jumps needed to reach the last index
        return jumps;
    }
}