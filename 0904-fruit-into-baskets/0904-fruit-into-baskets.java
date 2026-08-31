class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int ans = 0;
        
        while(r<fruits.length){
            int x = fruits[r];
            map.put(x, map.getOrDefault(x, 0)+1);
            
            while(map.size()>2){
                int fruit = fruits[l];
              map.put(fruit, map.get(fruit)-1);
              if(map.get(fruit) == 0) map.remove(fruit);
              l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }

        return ans;
    }
}