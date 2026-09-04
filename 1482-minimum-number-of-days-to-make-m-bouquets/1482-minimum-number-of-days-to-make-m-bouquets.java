class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long) m * k) return -1;

        int l = 1;
        int h = Integer.MIN_VALUE;
        for(int x : bloomDay){
          h = Math.max(h, x);
        }
               
        while(l<=h){
            int mid = l + (h-l)/2;
            int need = 0;
            int bq = 0;
            for(int bloom : bloomDay){
                if(bloom <= mid){
                   need++;
                   if(need == k){
                    bq++;
                    need = 0;
                   }
                }else{
                    need = 0;
                }
            }
            if(bq<m){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        return l;
    }
}