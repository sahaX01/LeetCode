class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        int l=0;
        int r=0;
        int maxLen = 0;
        while(r < n){
            char ch = s.charAt(r);

            while(map.containsKey(ch)){
                map.remove(s.charAt(l));
                l++;
            }
            map.put(ch, 1);
            
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}