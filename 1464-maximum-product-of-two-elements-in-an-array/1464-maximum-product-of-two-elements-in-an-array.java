class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num:nums){
            pq.add(num);
        }
        int h1 = pq.remove();
        int h2 = pq.remove();

        return (h1-1) * (h2-1);
    }
}