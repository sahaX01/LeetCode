class Solution {
     List<List<Integer>> list = new ArrayList<>();

    public void solve(int candidates[], int i, int target, ArrayList<Integer> temp){
        
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(i == candidates.length) return;
        if(target < 0) return;
        temp.add(candidates[i]);
        solve(candidates, i, target-candidates[i], temp);
        temp.remove(temp.size()-1);
        solve(candidates, i+1, target, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, 0, target, new ArrayList<>());
        return list;
    }
}