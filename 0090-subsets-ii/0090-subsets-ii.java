class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void solve(int nums[], List<Integer> temp, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // include
        temp.add(nums[i]);
        solve(nums, temp, i + 1);

        // backtrack
        temp.remove(temp.size() - 1);

        // go forward untill different number appears
        int idx = i + 1;
        while (idx < nums.length && nums[idx] == nums[idx - 1]) {
            idx++;
        }

        // exclude
        solve(nums, temp, idx);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, new ArrayList<>(), 0);

        return ans;
    }
}