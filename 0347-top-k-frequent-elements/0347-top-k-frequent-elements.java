import java.util.*;
class Solution {

    static class Pair implements Comparable<Pair>{
        int val;
        int freq;

        public  Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.freq - this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Integer key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }

        int arr[] = new int[k];

        for(int i=0; i<k; i++){
            arr[i] = pq.remove().val;
        }

        return arr;
    }
}