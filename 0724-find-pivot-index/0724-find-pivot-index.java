class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n+1];
        int suffix[] = new int[n+1];

        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        for(int j=n-1; j>=0; j--){
           suffix[j] = suffix[j+1] + nums[j];
        }
        
        int ans = Integer.MAX_VALUE;
        int k = 0;
        while(k<prefix.length && k+1<suffix.length){
            if(prefix[k] == suffix[k+1]){
                ans = Math.min(ans, k);
                
            }
            k++;
        }

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}