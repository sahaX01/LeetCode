class Solution {
    List<String> result = new ArrayList<>();
    public void solve(String s, int open, int close, int n, List<String> result){
        if(s.length() == 2*n){
            result.add(s);
            return;
        }
        if(open < n){
            solve(s+'(', open+1, close, n, result);
        }
        if(close < open){
            solve(s+')', open, close+1, n, result);
        }
    }
    public List<String> generateParenthesis(int n) {
        solve("", 0, 0, n, result);
        return result;
    }
}