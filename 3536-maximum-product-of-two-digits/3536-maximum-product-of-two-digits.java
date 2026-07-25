class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            char num1 = s.charAt(i);
            for(int j=i+1; j<s.length(); j++){
              char num2 = s.charAt(j);
              int ans = (num1 - '0') * (num2 - '0');
              max = Math.max(ans, max);
            }
        }

        return max;
    }
}