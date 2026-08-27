class Solution {
    StringBuilder result = new StringBuilder();
    public  boolean solve(StringBuilder curr, String target, boolean greater, int i, int freq[]){
        if(i == target.length()){
            if(greater){
                result = new StringBuilder(curr);
                return true;
            }
            return false;
        }

        for(char ch='a' ;ch<='z'; ch++){
            if(freq[ch-'a'] == 0) continue;

            if(greater == false && ch<target.charAt(i)) continue;

            boolean isGreater = greater || ch > target.charAt(i);
            curr.append(ch);
            freq[ch-'a']--;

            if(solve(curr, target, isGreater, i+1, freq)){
                return true;
            }

            curr.deleteCharAt(curr.length() - 1);
            freq[ch-'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        int freq[] = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        
        boolean greater = false;
        StringBuilder curr = new StringBuilder();
        solve(curr, target, greater, 0, freq);

        return result.toString();
    }
}