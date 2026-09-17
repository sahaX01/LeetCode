class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];

        int INF = 1000000000;

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }
        int l = 0;
        int r = 0;
        int sum = 0;

        int minLen = INF;
        int ans = INF;
        while(r<n){
            sum = sum + arr[r];
            while(sum>target){
                sum = sum - arr[l];
                l++;
            }
            if(sum == target){
                
                int len = r-l+1;
                // Previous subarray must end before l
                if (l > 0 && best[l - 1] != INF) {
                    ans = Math.min(ans, len + best[l - 1]);
                }

                minLen = Math.min(minLen, len);
            }
           
            best[r] = minLen;
            r++;
        }
         return ans == INF ? -1 : ans;
    }
}