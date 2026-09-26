class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for(int i=0; i<n; i++){
            long sum = 0;
            HashSet<Long> set = new HashSet<>();
            for(int j=i; j<n; j++){
                sum += nums[j];
                set.add(((2L*nums[j]) % k + k) % k);
                long rem = (sum % k + k) % k;

                if(rem == 0 || set.contains(rem)){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
}