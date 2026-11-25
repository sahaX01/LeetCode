class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1]));

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int x = intervals[0][0];
        int y = intervals[0][1];
        pq.add(new int[] { x, y });

        int group = 1;
        for (int i = 1; i < intervals.length; i++) {

            int newX = intervals[i][0];
            int newY = intervals[i][1];

            if (pq.peek()[1] < newX) {
                pq.poll();
            } else {
                group++;
            }

            pq.add(new int[] { newX, newY });
        }

        return group;
    }
}