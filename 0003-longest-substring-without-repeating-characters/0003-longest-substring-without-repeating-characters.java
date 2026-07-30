class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j<n){
          char ch = s.charAt(j);
        
           while(map.containsKey(ch)){
            map.remove(s.charAt(i));
            i++;
           }
          
            map.put(ch, 1);
          
          maxlen = Math.max(maxlen, j+1-i);
           j++;
        }

        return maxlen;
    }
}