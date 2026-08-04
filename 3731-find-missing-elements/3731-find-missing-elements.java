class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean arr[] = new boolean[max+1];

        for(int i=0; i<nums.length; i++){
            arr[nums[i]] = true;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=min; i<arr.length; i++){
            if(!arr[i]) ans.add(i);
        }

        return ans;
    }
}