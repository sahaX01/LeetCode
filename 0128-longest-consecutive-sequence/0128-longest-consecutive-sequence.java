class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int ans = 0;

        for (int x : set) {
            // x is the starting of the sequenece
            if (!set.contains(x - 1)) {
                int current = x;
                int len = 1;
                while (set.contains(current + 1)) {
                    current++;
                    len++;
                }
                ans = Math.max(ans, len);
            }

        }
        return ans;
    }
}