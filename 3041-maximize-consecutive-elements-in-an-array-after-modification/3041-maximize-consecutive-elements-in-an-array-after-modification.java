class Solution {
    int n;
    Integer[][] dp;

    public int findMethod(int[] nums, int start, int target) {
        int l = start;
        int r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (l < n && nums[l] == target) {
            return l;
        }

        return -1;
    }

    public int solve(int i, int inc, int[] nums) {
        if (dp[i][inc] != null) {
            return dp[i][inc];
        }
        int currVal = nums[i] + inc; // inc = 0/1;
        int len = 1;
        //1. find currVal+1 directly
        int j = findMethod(nums, i + 1, currVal + 1);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 0, nums));
        }
        //2. find currVal then increment by 1
        j = findMethod(nums, i + 1, currVal);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 1, nums));
        }

        return dp[i][inc] = len;
    }

    public int maxSelectedElements(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);

        dp = new Integer[nums.length][2];
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
        }

        return result;
    }
}