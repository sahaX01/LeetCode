class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        
        for(int k=0; k<n; k++){
            if(k>0 && nums[k] == nums[k-1]) continue;
            for(int l=k+1; l<n; l++){
                if(l>k+1 && nums[l] == nums[l-1]) continue;
                int i = l+1;
                int j = n-1;
                
                while(i<j){
                    long sum = (long) nums[k] + nums[l] + nums[i] + nums[j];
                    if(sum == target ){
                        result.add(Arrays.asList(nums[k], nums[l], nums[i], nums[j]));
                        
                        i++;
                        j--;

                        while(i<j && nums[i] == nums[i-1]){
                            i++;
                        }
                        while(i<j && nums[j] == nums[j+1]){
                            j--;
                        }
                    }else if(sum<target){
                        i++;
                    }else{
                        j--;
                    }
                }
            }
        }

        return result;
    }
}