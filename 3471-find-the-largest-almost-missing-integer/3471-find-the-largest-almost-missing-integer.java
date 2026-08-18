class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int l = 0; l < nums.length; l++) {
            int target = nums[l];
            if (map.containsKey(target)) {
                continue;
            }

            for (int i = 0; i <= nums.length - k; i++) {
                // search in current window
                boolean found = false;
                for (int j = i; j < i + k; j++) {
                    int num = nums[j];

                    if (target == num) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    map.put(target, map.getOrDefault(target, 0) + 1);
                }

            }
        }

        int ans = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}