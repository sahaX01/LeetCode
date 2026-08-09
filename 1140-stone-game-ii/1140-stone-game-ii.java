class Solution {

    // dp[person][i][M]
    // person = 0 -> Bob
    // person = 1 -> Alice
    // i      -> current starting index
    // M      -> current M value
    static Integer[][][] dp;

    public static int solveForAlice(int[] piles, int person, int i, int M) {

        int n = piles.length;

        // If there are no piles remaining,
        // Alice cannot get any more stones.
        if(i >= n) return 0;

        // If this state is already calculated,
        // return the stored answer instead of calculating again.
        if(dp[person][i][M] != null){
            return dp[person][i][M];
        }

        // Stores the total stones taken in the current move.
        int stones = 0;

        // Initial value of result.
        int result = -1;

        // Alice wants to MAXIMIZE her total stones.
        if(person == 1){
            result = Integer.MIN_VALUE;
        }

        // Bob wants to MINIMIZE Alice's total stones.
        else{
            result = Integer.MAX_VALUE;
        }

        // Current player can take x piles,
        // where 1 <= x <= 2 * M.
        //
        // But we cannot take more piles than are remaining.
        for(int x = 1; x <= Math.min(2 * M, n - i); x++){

            // Add the x-th pile to the current player's stones.
            stones = stones + piles[i + x - 1];

            if(person == 1){ // Alice's turn

                // Alice takes x piles.
                //
                // 'stones' = stones Alice gets in this move.
                //
                // After Alice's move:
                // person becomes 0 -> Bob's turn
                //
                // New index = i + x
                //
                // New M = max(old M, x)
                //
                // Alice wants to MAXIMIZE her final total.
                result = Math.max(
                    result,
                    stones + solveForAlice(
                        piles,
                        0,
                        i + x,
                        Math.max(M, x)
                    )
                );

            }else{ // Bob's turn

                // Bob takes x piles.
                //
                // We DON'T add Bob's stones because
                // our function calculates ALICE'S total.
                //
                // After Bob's move:
                // person becomes 1 -> Alice's turn
                //
                // Bob wants to MINIMIZE Alice's final total.
                result = Math.min(
                    result,
                    solveForAlice(
                        piles,
                        1,
                        i + x,
                        Math.max(M, x)
                    )
                );
            }
        }

        // Store the answer for this state
        // so we don't calculate the same state again.
        return dp[person][i][M] = result;
    }

    public int stoneGameII(int[] piles) {

        // n <= 100 in the problem,
        // so 101 is enough for i and M indices.
        dp = new Integer[2][101][101];

        // Start with:
        // person = 1 -> Alice
        // i = 0      -> first pile
        // M = 1      -> initial M
        return solveForAlice(piles, 1, 0, 1);
    }
}