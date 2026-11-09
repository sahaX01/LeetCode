class Solution {
    HashMap<Integer, String> map = new HashMap<>();
    Solution(){
    map.put(2,"abc");
    map.put(3,"def");
    map.put(4,"ghi");
    map.put(5,"jkl");
    map.put(6,"mno");
    map.put(7,"pqrs");
    map.put(8,"tuv");
    map.put(9,"wxyz");
    }

    List<String> answer = new ArrayList<>();

    public void solve(String s, int idx, StringBuilder sb){

        if(idx == s.length()){
         answer.add(sb.toString());
         return;
        }
        int key = s.charAt(idx) - '0';
        String str = map.get(key);
        for(int i=0; i<str.length(); i++){
          char ch = str.charAt(i);
          sb.append(ch);
          solve(s, idx+1, sb);
          sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
       solve(digits, 0, new StringBuilder(""));
       return answer;
    }
}