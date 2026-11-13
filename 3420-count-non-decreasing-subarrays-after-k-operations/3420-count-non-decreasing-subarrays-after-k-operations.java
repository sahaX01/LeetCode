
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;
        int l = n - 1;
        int r = n - 1;

        long ans = 0;
        long op = 0;

        Deque<int[]> dq = new ArrayDeque<>();

        while (l >= 0) {

            int count = 1;

            while (!dq.isEmpty() && dq.peekLast()[0] < nums[l]) {

                int[] temp = dq.pollLast();

                op += (long) (nums[l] - temp[0]) * temp[1];
                count += temp[1];
            }

            dq.offerLast(new int[]{nums[l], count});

            while (op > k) {

                int[] temp = dq.peekFirst();

                op -= (long) (temp[0] - nums[r]);

                if (temp[1] == 1) {
                    dq.pollFirst();
                } else {
                    temp[1]--;
                }

                r--;
            }

            ans += r - l + 1;
            l--;
        }

        return ans;
    }
}
