class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        HashMap<TreeMap<Character, Integer>, Integer> map = new HashMap<>();
        
        int group = 0;
        
        for(String str : strs){
            TreeMap<Character, Integer> tmap = new TreeMap<>();
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                tmap.put(ch, tmap.getOrDefault(ch, 0)+1);
            }
            if(!map.containsKey(tmap)){
              map.put(tmap, group);
              result.add(new ArrayList<>());
              group++;
            }
            
            int currentgroup = map.get(tmap);
            result.get(currentgroup).add(str);
            
        }

        return result;
    }
}