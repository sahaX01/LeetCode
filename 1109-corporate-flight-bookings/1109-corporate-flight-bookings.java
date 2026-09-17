class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n+1];

        for(int i=0; i<bookings.length; i++){
            int l = bookings[i][0];
            int r = bookings[i][1];
            int val = bookings[i][2];
            
            // Start adding
            ans[l-1] += val;
            // Stop adding after r
            ans[r] -= val;
        }

        // prefix sum
        for(int i=1; i<n+1; i++){
            ans[i] = ans[i] + ans[i-1];
        }

        return Arrays.copyOf(ans , n);
    }
}