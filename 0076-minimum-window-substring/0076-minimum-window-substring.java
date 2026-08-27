class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int l = 0;
        int r = 0;
        String ans = new String();
        int count = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while (count == t.length()) {
                if (ans.equals("") || r - l + 1 < ans.length()) {
                    ans = s.substring(l, r + 1);
                }

                char leftchar = s.charAt(l);

                if (map.containsKey(leftchar)) {
                    map.put(leftchar, map.get(leftchar) + 1);
                    if (map.get(leftchar) > 0) {
                        count--;
                    }
                }

                l++;
            }
            r++;
        }

        return ans;
    }
}