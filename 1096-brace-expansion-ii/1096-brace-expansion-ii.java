class Solution {
    String s;
    int n;
    int idx = 0;

    public Set<String> performUnion(String s){
        Set<String> result = new HashSet<>();
        while(true){
            Set<String> temp = performConcat(s);
            result.addAll(temp);
            if(idx < n && s.charAt(idx) == ','){
                idx++;
            }else{
                break;
            }
        }
        return result;
    }
    public Set<String> getUnit(String s){
    Set<String> result = new HashSet<>();

        if(s.charAt(idx) == '{'){
            idx++;
            result = performUnion(s);
            idx++;
        }else{
            result.add(String.valueOf(s.charAt(idx)));
            idx++;
        }
    return result;
    }
    public Set<String> performConcat(String s){
      Set<String> result = new HashSet<>();
      result.add("");
      while(idx < n && 
      (s.charAt(idx) == '{' || Character.isLetter(s.charAt(idx)))
      ){
        Set<String> temp = getUnit(s);
        Set<String> concat = new HashSet<>();
        for(String left : result){
            for(String right : temp){
                concat.add(left + right);
            }
        }
        result = concat;
      }
      return result;
    }
    public List<String> braceExpansionII(String expression) {
        n = expression.length();
        s = expression;
          
        Set<String> result = performUnion(s);
        List<String> ans = new ArrayList<>(result);
        
        Collections.sort(ans);
        return ans;
    }
}