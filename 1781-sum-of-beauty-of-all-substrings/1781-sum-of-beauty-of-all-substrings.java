class Solution {
    public int beautySum(String s) {
        int n = s.length(); 
        int sum = 0;

        for(int i=0; i<n; i++){
            int freq[] = new int[26];
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                int maxfreq = 0;
                int minfreq = Integer.MAX_VALUE;
                for(int k=0; k<26; k++){
                  if(freq[k]>0){
                    maxfreq = Math.max(maxfreq, freq[k]);
                    minfreq = Math.min(minfreq, freq[k]);
                  }
                }
                sum += maxfreq - minfreq;
            }
        }

        return sum;
    }
}