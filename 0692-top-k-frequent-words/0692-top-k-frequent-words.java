class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
          map.put(word, map.getOrDefault(word, 0)+1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b)-> {
            if(b.getValue() == a.getValue()){
               return a.getKey().compareTo(b.getKey());
            }
            return Integer.compare(b.getValue(), a.getValue());
        }
            
            );
        List<String> ans = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : list){
           if(k>0){
             ans.add(entry.getKey());
             k--;
           }
           
        }

        return ans;
    }
}