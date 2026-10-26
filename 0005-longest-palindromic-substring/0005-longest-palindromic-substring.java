class Solution {
    public static boolean palindrome(String str){
      int i = 0;
      int j = str.length()-1;
      while(i<=j){
        if(str.charAt(i) == str.charAt(j)){
            i++;
            j--;
        }else{
            return false;
        }
      }
      return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        
        String ans = "";
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
              String str = s.substring(i, j+1);
              if(palindrome(str) == true && str.length()>ans.length()){
                ans = str;
              }
            }
        }

        return ans;
    }
}