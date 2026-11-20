class Solution {
    List<String> ans = new ArrayList<>();
    
    public void helper(String s, int target, int idx, String path, long eval, long last){
        if(idx == s.length()){
            if(eval == target){
                ans.add(path);
                return;
            }
        }
        
        String currStr = "";
        long num=0;

        for(int j=idx; j<s.length(); j++){
            // leading zeros
            if(j>idx && s.charAt(idx)=='0'){
                return;
            }
            currStr += s.charAt(j);
            num = num*10 + s.charAt(j)-'0';
            if(idx == 0){
                helper(s, target, j+1, path+currStr, eval + num, num);
            }else{
                helper(s, target, j+1, path+"+"+currStr, eval + num, num);
                helper(s, target, j+1, path+"-"+currStr, eval - num, -num);
                helper(s, target, j+1, path+"*"+currStr, eval - last + last * num, last*num);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
    
        helper(num, target, 0, "", 0, 0);
        return ans;
    }
}