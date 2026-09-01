class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        int n = nums.length;
        for(int k=0; k<n; k++){
            int i = k+1;
            int j = n-1;
            while(i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if(Math.abs(target-sum)< Math.abs(target-ans)){
                    ans = sum;
                }
                
                if(sum<target){
                    i++;
                }else{
                    j--;
                }
            }

        }
        return ans;
    }
}