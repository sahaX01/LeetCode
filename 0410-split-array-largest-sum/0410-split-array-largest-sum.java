class Solution {
    public static boolean isPossible(int barrier, int nums[], int limit){
        int allocate = 1;
        int total = 0;

        for(int i=0; i<nums.length; i++){
          if(nums[i] > barrier){
            return false;
          }else if(total+nums[i] > barrier){
            allocate += 1;
            total = nums[i];
          }else{
            total += nums[i];
          }
        }

        if(allocate > limit){
            return false;
        }

        return true;
    }
    public int splitArray(int[] nums, int k) {
        int h = 0;
        int l = Integer.MAX_VALUE;

        for(int num : nums){
            h += num;
            l = Math.min(l, num);
        }
        int result = 0;

        while(l<=h){
            int mid = (l+h)/2;
            if(isPossible(mid, nums, k)){
                result = mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return result;
    }
}