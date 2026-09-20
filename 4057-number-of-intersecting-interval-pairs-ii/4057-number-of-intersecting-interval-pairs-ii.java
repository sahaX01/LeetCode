class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int st[] = new int[n];
        int ed[] = new int[n];

        for(int i=0; i<n; i++){
            st[i] = intervals[i][0];
            ed[i] = intervals[i][1];
        }


        Arrays.sort(st);
        Arrays.sort(ed);
        
        long ans = 0;
        int idx = 0;

        for(int i=0; i<n; i++){
            while(ed[idx] < st[i]){
                idx++;
            }
            ans += i - idx;
        }
        return ans;
    }
}