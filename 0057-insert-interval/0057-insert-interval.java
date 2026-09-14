class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int min = newInterval[0];
        int max = newInterval[1];
        for(int i=0; i<intervals.length; i++){
            ArrayList<Integer> ll = new ArrayList<>();
            // no overlap
            if(intervals[i][1]<min || intervals[i][0]>max){
                ll.add(intervals[i][0]);
                ll.add(intervals[i][1]);
                ans.add(ll);
            }
            else{
                // overlap
               min = Math.min(intervals[i][0], min);
               max = Math.max(intervals[i][1], max);
            }
        }
        
        int result[][] = new int[ans.size()+1][2];
        boolean inserted = false;
        int j = 0;
        for(int i=0; i<result.length; i++){
            
            if(!inserted && (j == ans.size() || min < ans.get(j).get(0))){
              result[i][0] = min;
              result[i][1] = max;
              inserted = true;
            }else{
               result[i][0] = ans.get(j).get(0);
               result[i][1] = ans.get(j).get(1);
               j++;
            }
        }

        return result;
    }
}