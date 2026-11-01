class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        int min = Integer.MAX_VALUE;
        for(int x : nums){
            min = Math.min(min, x);
        }

        for(int x : nums){
            moves += x - min;
        }

        return moves;
    }
}