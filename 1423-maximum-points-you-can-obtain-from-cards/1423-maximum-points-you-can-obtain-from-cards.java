class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0;
        int r = 0;
        int unselected = n - k;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int tsum = 0;
        for (int x : cardPoints) {
            tsum += x;
        }
        if(unselected == 0) return tsum;
        while (r < n) {
            sum = sum + cardPoints[r];
            if (r - l + 1 > unselected) {
                sum = sum - cardPoints[l];
                l++;
            }
            if (r - l + 1 == unselected) {
                min = Math.min(min, sum);
            }

            r++;
        }

        return tsum - min;
    }
}