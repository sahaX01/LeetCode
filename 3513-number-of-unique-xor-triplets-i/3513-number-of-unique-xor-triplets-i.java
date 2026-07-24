class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        if(nums.length == 1) return 1;
        if(nums.length == 2) return 2;
         
        if(nums.length>=3){
            int ans = 1;
            while(ans<=nums.length){
                ans = ans << 1;
            }
            return ans;
        }
        
        return -1;
    }
}