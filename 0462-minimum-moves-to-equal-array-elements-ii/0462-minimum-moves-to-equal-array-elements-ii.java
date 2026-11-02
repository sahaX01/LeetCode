class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int mid = n/2;

        int val = nums[mid];

        int moves = 0;
        for(int x : nums){
            moves += Math.abs(val - x);
        }

        return moves;
    }
}