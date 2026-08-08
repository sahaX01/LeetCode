class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int result[] = new int[m];
        Arrays.fill(result, -1);
        int i = n-1;
        int j = m-1;

        while(i>=0 && j>=0){
            if(word1.charAt(i) == word2.charAt(j)){
              result[j] = i;
              j--;
            }
            i--;
        }

         i = 0;
         j = 0;
        boolean isUsed = false;
        int ans[] = new int[m];
        Arrays.fill(ans, -1);
        
        while(i<n && j<m){
          if(word1.charAt(i) == word2.charAt(j)){
            ans[j] = i;
            j++;
          }else{
            if(!isUsed && (j==m-1 || i+1<=result[j+1])){
                ans[j] = i;
                isUsed = true;
                j++;
            }
          }
          i++;
        }

        for(int num:ans){
            if(num == -1){
              return new int[0];
            }
        }

        return ans;
    }
}