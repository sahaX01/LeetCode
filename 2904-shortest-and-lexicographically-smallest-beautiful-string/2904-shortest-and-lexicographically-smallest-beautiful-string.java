class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        int countOne = 0;
        for(int i=0; i<len; i++){
           char ch = s.charAt(i);
           if(ch =='1') countOne++;
        }

        if(countOne < k) return "";
        
        int l = 0;
        int r = 0;
        countOne = 0;
        String ans = new String();
        String temp = new String();
        
        for(; r<len; r++){
           char ch = s.charAt(r);
           if(ch == '1') countOne++;
           
           while(countOne>k){
            char ch1 = s.charAt(l);
            if(ch1 == '1') countOne--;
            l++;
           }
           if(countOne == k){
            
            while(l<=r && s.charAt(l)=='0'){
                l++;
            }
            temp = s.substring(l, r+1);
            if(ans.equals("") || temp.length()<ans.length()){
                ans = temp;
            }else if(temp.length() == ans.length() && temp.compareTo(ans)<0){
                ans = temp;
            }
           }
        }
    
        return ans;
      
    }
}