
import java.util.*;

class Solution {

    static int X, K, N;
    static long[] cost;
    static Long[][] dp;

    static long INF = (long) 1e18;

    // Two multisets
    static TreeMap<Integer, Integer> left, right;

    static long sumLeft, sumRight;
    static int leftSize, rightSize;

    // Add element to a TreeMap
    static void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    // Remove element from a TreeMap
    static void remove(TreeMap<Integer, Integer> map, int val) {
        int cnt = map.get(val);

        if (cnt == 1) map.remove(val);
        else map.put(val, cnt - 1);
    }

    static void addLeft(int val) {
        add(left, val);
        sumLeft += val;
        leftSize++;
    }

    static void addRight(int val) {
        add(right, val);
        sumRight += val;
        rightSize++;
    }

    static int removeMaxLeft() {
        int val = left.lastKey();
        remove(left, val);
        sumLeft -= val;
        leftSize--;
        return val;
    }

    static int removeMinRight() {
        int val = right.firstKey();
        remove(right, val);
        sumRight -= val;
        rightSize--;
        return val;
    }

    // Keep left size equal to right size or one greater
    static void balance() {
        while (leftSize > rightSize + 1) {
            addRight(removeMaxLeft());
        }

        while (leftSize < rightSize) {
            addLeft(removeMinRight());
        }
    }

    static void insert(int val) {
        if (leftSize == 0 || val <= left.lastKey()) {
            addLeft(val);
        } else {
            addRight(val);
        }

        balance();
    }

    static void erase(int val) {
        if (left.containsKey(val)) {
            remove(left, val);
            sumLeft -= val;
            leftSize--;
        } else {
            remove(right, val);
            sumRight -= val;
            rightSize--;
        }

        balance();
    }

    // Minimum operations to make current window equal
    static long getCost() {
        long median = left.lastKey();

        return median * leftSize - sumLeft
             + sumRight - median * rightSize;
    }

    // DP
    public static long solve(int i, int count) {

        if (count == K) return 0;

        if (i >= N) return INF;

        if ((long) i + (long) (K - count) * X > N) {
            return INF;
        }

        if (dp[i][count] != null) {
            return dp[i][count];
        }

        // Take current subarray
        long take = cost[i] + solve(i + X, count + 1);

        // Skip current index
        long skip = solve(i + 1, count);

        return dp[i][count] = Math.min(take, skip);
    }

    public long minOperations(int[] nums, int x, int k) {

        X = x;
        K = k;
        N = nums.length;

        if (k == 0) return 0;
        if (x > N || (long) x * k > N) return -1;

        cost = new long[N];
        dp = new Long[N + 1][K + 1];

        // Initialize sliding window
        left = new TreeMap<>();
        right = new TreeMap<>();

        sumLeft = 0;
        sumRight = 0;
        leftSize = 0;
        rightSize = 0;

        // First window
        for (int i = 0; i < X; i++) {
            insert(nums[i]);
        }

        // Calculate cost of every window
        for (int i = 0; i + X <= N; i++) {

            cost[i] = getCost();

            if (i + X < N) {
                erase(nums[i]);
                insert(nums[i + X]);
            }
        }

        return solve(0, 0);
    }
}
