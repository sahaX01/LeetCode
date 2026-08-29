class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int sorted[] = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> groupNumber = new HashMap<>();
        HashMap<Integer, Queue<Integer>> groupValue = new HashMap<>();
        int group = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i>0 && Math.abs(sorted[i]-sorted[i-1])>limit){
                group++;
            }
            groupNumber.put(sorted[i], group);
            groupValue.putIfAbsent(group, new LinkedList<>());
            groupValue.get(group).add(sorted[i]);
        }
        
        int original[] = new int[nums.length];

        for(int k=0; k<nums.length; k++){
          int x = nums[k];
          int currentgroup = groupNumber.get(x);
          original[k] = groupValue.get(currentgroup).remove();
        }

        return original;
    }
}