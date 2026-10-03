class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int open = 0;
        int close = 0;
        // left to right
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                close++;
            }
            
            if(close>open){
                open = 0;
                close = 0;
            }else if(open == close){
                max = Math.max(max, open + close);
            }
        }

        // right to left
        open = 0;
        close = 0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch ==')'){
                close++;
            }else if(ch == '('){
                open++;
            }
            if(open>close){
                open = 0;
                close = 0;
            }else if(open == close){
                max = Math.max(max, open+close);
            }
        }
        return max;
    }
}