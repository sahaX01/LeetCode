class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int prefix[] = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            int val = prefix[0] + nums[i];
            prefix[i+1] = Math.max(prefix[i],val);
        }
        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            min = Math.min(nums[i], min);
            int d = prefix[i+1] - min;
            if(d<=k){
                ans = Math.min(i, ans);
            } 
        }

        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}