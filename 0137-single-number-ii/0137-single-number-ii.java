class Solution {
    public int singleNumber(int[] nums) {

        int ones = 0; // Store bits appearing once
        int twos = 0; // Store bits appearing twice

        for (int i = 0; i < nums.length; i++) {

            // Update ones and remove bits already present in twos
            ones = (ones ^ nums[i]) & (~twos);

            // Update twos and remove bits already present in ones
            twos = (twos ^ nums[i]) & (~ones);
        }

        return ones; // Return the unique number
    }
}