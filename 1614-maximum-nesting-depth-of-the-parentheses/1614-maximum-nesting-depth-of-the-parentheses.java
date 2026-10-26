class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int depth = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else if(ch == ')' && !st.isEmpty()){
                depth = Math.max(st.size(), depth);
                st.pop();
            }
        }
        return depth;
    }
}