class Solution {
    public int myAtoi(String s) {
        int mul = 1;
        long ans = 0;
        boolean started = false;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ' && !started) continue;
            else if(ch == '-' && !started){
                started = true;
                mul = -1;
            }
            else if(ch == '+' && !started){
                started = true;
            }
            else if(!Character.isDigit(ch)){
                break;
            }else{
                started = true;
                int rem = ch - '0';
                ans = ans * 10 + rem;
                
                if(mul == 1 && ans > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(mul == -1 && ans > 2147483648L){
                    return Integer.MIN_VALUE;
                }
            }
        }

        return (int) (ans * mul);
    }
}