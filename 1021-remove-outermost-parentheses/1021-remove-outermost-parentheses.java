class Solution {
    public String removeOuterParentheses(String s) {
        int c = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(c>0){
                    sb.append(ch);
                }
                c++;
            }else{
                c--;
                if(c>0){
                 sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}