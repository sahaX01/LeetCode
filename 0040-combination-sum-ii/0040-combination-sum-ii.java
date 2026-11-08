class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public void solve(int candidates[], int i, int target, ArrayList<Integer> temp) {

        if (target == 0) {

            list.add(new ArrayList<>(temp));

            return;
        }

        if (i == candidates.length || target < 0)
            return;
        // take
        temp.add(candidates[i]);

        solve(candidates, i + 1, target - candidates[i], temp);
        temp.remove(temp.size() - 1);

        // Skip all duplicate occurrences
        int next = i + 1;

        while (next < candidates.length &&
               candidates[next] == candidates[i]) {
            next++;
        }

        // skip
        solve(candidates, next, target, temp);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>());

        return list;
    }
}