class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int k = -1; // 111111 all bits are set

        for(int i=0; i<n; i++){
            if(nums[i] != i){
                k = k & nums[i];
            }
        }

        return k == -1 ? 0 : k;
    }
}