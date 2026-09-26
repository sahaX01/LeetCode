class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        int n = knowledge.size();
        for(int i=0; i<n; i++){
            String k = knowledge.get(i).get(0);
            String v = knowledge.get(i).get(1);
            map.put(k, v);
        }

        int m = s.length();
        int oi = -1;
        int ei = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                int j = i+1;
                while(s.charAt(j) != ')'){
                    j++;
                }
                String k = s.substring(i+1, j);
                if(map.containsKey(k)){
                    sb.append(map.get(k));
                }else{
                    sb.append("?");
                }
                i=j;
            }else{
                sb.append(ch);
            }
        }

            
        return sb.toString();
    }
}