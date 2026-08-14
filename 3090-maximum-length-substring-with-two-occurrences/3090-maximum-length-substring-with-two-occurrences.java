class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxlen = Integer.MIN_VALUE;

        for(; right<n; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.get(ch)>2){
                char leftch = s.charAt(left);
                map.put(leftch, map.get(leftch)-1);
                left++;
            }

            maxlen = Math.max(maxlen, right-left+1);
        }

        return maxlen;
    }
}