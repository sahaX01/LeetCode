class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int windowsize = s1.length();
        int l=0;
        int r=windowsize-1;
       
        int n = s2.length();
        
        while(r<n){
            HashMap<Character,Integer> windowfreq = new HashMap<>();
            boolean pos = true;
            for(int i=l; i<=r; i++){
                char ch = s2.charAt(i);
                windowfreq.put(ch, windowfreq.getOrDefault(ch, 0)+1);
            }

            for(char key: map.keySet()){
                if(!map.get(key).equals(windowfreq.getOrDefault(key, 0))){
                   pos = false;
                   break;
                }
            }
            if(pos) return true;
            l++;
            r++;
        }


        return false;
    }
}