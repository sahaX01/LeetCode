class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        int depth = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
              depth++;
            }else if(ch == ')'){
              depth --;
              if(s.charAt(i-1) == '('){
                score += 1 << depth;
              }
            }
        }
        return score;
    }
}