class Solution {
    public int maximumGap(String skill, String station) {
        int n = station.length();
        int m = skill.length();
        int left[] = new int[m];
        int right[] = new int[m];
        
        int i = 0;

        for(int j=0; i<m && j<n; j++){
            if(skill.charAt(i) == station.charAt(j)){
                left[i] = j;
                i++;
            }
        }
        i = m-1;
        for(int j=n-1; i>=0 && j>=0; j--){
            if(skill.charAt(i) == station.charAt(j)){
                right[i] = j;
                i--;
            }
        }
        int gap = 0;
        for(int k=1; k<m ;k++){
          gap = Math.max(gap, right[k]-left[k-1]);
        }

        return gap;
    }
}