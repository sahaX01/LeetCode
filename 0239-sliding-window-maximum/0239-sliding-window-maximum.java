class Solution {

    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx){
          this.val = val;
          this.idx = idx;
        }

        @Override

        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int res[] = new int[nums.length-k+1];
        for(int i=0; i<k; i++){
            pq.add(new Pair(nums[i], i));
        }
        
        res[0] = pq.peek().val;

        for(int i=k; i<nums.length; i++){
            pq.add(new Pair(nums[i], i));
            while(pq.peek().idx <=(i-k)){
                pq.remove();
            }
            res[i-k+1] = pq.peek().val;
        }

        return res;
    }
}