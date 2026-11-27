class Solution {
    public static int solve(String s, int k){
        int l = 0;
        int r = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        while(r < n){
          char ch = s.charAt(r);
          map.put(ch, map.getOrDefault(ch, 0)+1);
          while(map.size()>k){
            ch = s.charAt(l);
            map.put(ch, map.get(ch)-1);
            if(map.get(ch) == 0){
                map.remove(ch);
            }
            l++;
          }
          ans += r-l+1;
          r++;
        }
        return ans;
    }
    public int numberOfSubstrings(String s) {
        return solve(s, 3) - solve(s, 2);
    }
}