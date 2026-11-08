class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void solve(int digits[], int i, int target, ArrayList<Integer> temp, int size){
        if(target == 0 && size == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(i == digits.length || target < 0){
            return;
        }
        // take
        temp.add(digits[i]);
        solve(digits, i+1, target-digits[i], temp, size-1);
        temp.remove(temp.size()-1);

        // skip
        solve(digits, i+1, target, temp, size);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int digits[] = {1,2,3,4,5,6,7,8,9};
        solve(digits, 0, n, new ArrayList<>(), k);

        return list;
    }
}