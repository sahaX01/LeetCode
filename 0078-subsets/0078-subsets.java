class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void solve(int nums[], List<Integer> temp, int i){
         if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
         }
         // include 
         temp.add(nums[i]);
         solve(nums, temp, i+1);

         // backtrack
         temp.remove(temp.size()-1);

         // exclude
         solve(nums, temp, i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        solve(nums, new ArrayList<>(), 0);
        return ans;
    }
}