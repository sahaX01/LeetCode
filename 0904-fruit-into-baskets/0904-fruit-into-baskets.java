class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        while(r < n){
          int x = fruits[r];
          map.put(x, map.getOrDefault(x, 0)+1);
          while(map.size() > 2){
            int v = map.get(fruits[l]);
            map.put(fruits[l], v-1);

            if(map.get(fruits[l]) == 0){
                map.remove(fruits[l]);
            }
            l++;
          }
          ans = Math.max(ans, r-l+1);
          r++;
        }

        return ans;
    }
}