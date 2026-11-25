class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));

        int r = intervals.length;
        int arr[][] = new int[r][2];
        int idx = 0;
        arr[0][0] = intervals[0][0];
        arr[0][1] = intervals[0][1];

        for(int i=1; i<r; i++){
            if(intervals[i][0] <= arr[idx][1]){
                arr[idx][1] = Math.max(intervals[i][1], arr[idx][1]);
            }else{
                idx++;
                arr[idx][0] = intervals[i][0];
                arr[idx][1] = intervals[i][1];
            }
        }

        return Arrays.copyOf(arr, idx+1);
    }
}