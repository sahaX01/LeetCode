class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];
        for(int i=0; i<bookings.length; i++){
            int l = bookings[i][0];
            int r = bookings[i][1];
            int val = bookings[i][2];
            for(int idx=l-1; idx<r; idx++){
                ans[idx] += val;
            }
        }
        return ans;
    }
}