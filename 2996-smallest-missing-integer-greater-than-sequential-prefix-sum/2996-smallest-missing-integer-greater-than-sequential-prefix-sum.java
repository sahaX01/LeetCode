class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        if(nums.length == 1){
            return nums[0] + 1;
        }
    
        int prefixSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                break;

            } else {
               prefixSum += nums[i];
            }
        }
        int ans = prefixSum;
        
        while(set.contains(ans)){
            ans = ans + 1;
        }
        return ans;
    }
}