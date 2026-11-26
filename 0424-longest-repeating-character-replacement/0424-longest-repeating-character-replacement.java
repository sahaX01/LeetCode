class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int maxfreq = 0;

        while(r < n){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxfreq = Math.max(maxfreq, map.get(ch));
            if(r-l+1 - maxfreq > k){
                  ch = s.charAt(l);
                map.put(ch, map.get(ch)-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }

        return ans;
    }
}