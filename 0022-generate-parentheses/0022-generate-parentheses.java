class Solution {
    List<String> result = new ArrayList<>();
    public boolean isValid(StringBuilder sb){
        int count = 0;
        for(int i=0; i<sb.length(); i++){
              char ch = sb.charAt(i);
              if(ch == '(') count ++;
              else count --;

              if(count < 0) return false;
            
        }
        return count == 0;
    }
    public void solve(StringBuilder sb, int n){
        if(sb.length() == 2 * n){
            if(isValid(sb)){
                result.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        solve(sb, n);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        solve(sb, n);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        solve(new StringBuilder(), n);
        return result;
    }
}