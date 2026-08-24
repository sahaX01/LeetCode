class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) -> {
            if(a.getValue() == b.getValue()){
                return b.getKey() - a.getKey();
            }

            return a.getValue() - b.getValue();
        });

        int ans[] = new int[nums.length];
        int k = 0;
        for(Map.Entry<Integer,Integer> entry: list){
            int value = entry.getValue();
            int key = entry.getKey();
            while(value-->0){
                ans[k++] = key;
            }
        }

        return ans;
    }
}