class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n+1];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, prefix[0] + nums[i]);
            prefix[i+1] = max;
        }

        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
             min = Math.min(min, nums[i]);
            int d = prefix[i+1] - min;
            if(d<=k) ans = i;
        }

        return ans;
    }
}