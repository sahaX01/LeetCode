class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[1], b[1]));

        int r = intervals.length;

        int remove = 0;
        int idx = 0;
        for(int i=1; i<r; i++){
          if(intervals[i][0]<intervals[idx][1]){
            remove++;
          }else{
            idx = i;
          }
        }

        return remove;
    }
}