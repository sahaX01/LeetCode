class Solution {
    public int minChanges(String s) {
        int cnt = 1;
        int ans = 0;
        for(int i=1; i<s.length(); i++){
          if(s.charAt(i) == s.charAt(i-1)){
            cnt++;
          }else{
            if(cnt % 2 != 0){
              ans++;
              i++;
            }
            cnt = 1;
          }
        }
        return ans;
    }
}