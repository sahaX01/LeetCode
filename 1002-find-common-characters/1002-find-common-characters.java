class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<HashMap<Character, Integer>> ll = new ArrayList<>();

        for(String word : words){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<word.length(); i++){
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
            }
            ll.add(map);
        }

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i<26; i++){
            char ch = (char)('a'+i);
            int freq = ll.get(0).getOrDefault(ch, 0);
            for(int j=1; j<ll.size(); j++){
              int allfreq = ll.get(j).getOrDefault(ch, 0);
              freq = Math.min(freq, allfreq);
            }
            for(int k=0; k<freq; k++){
               ans.add(ch+"");
            }
            
        }
        return ans;
    }
}