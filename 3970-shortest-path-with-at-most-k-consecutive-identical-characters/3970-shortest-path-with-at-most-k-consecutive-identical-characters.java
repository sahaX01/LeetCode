import java.util.*;

class Solution {

    static class Pair implements Comparable<Pair> {
        int node;
        int count;
        long cost;

        public Pair(int node, int count, long cost) {
            this.node = node;
            this.count = count;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return Long.compare(this.cost, p2.cost);
        }
    }

    static class Edge {
        int dest;
        int wt;

        public Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Edge(v, wt));
        }

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[0][1] = 0;
        pq.add(new Pair(0, 1, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            int u = curr.node;
            int count = curr.count;
            long cost = curr.cost;

            if (cost != dist[u][count]) {
                continue;
            }

            if (u == n - 1) {
                return (int) cost;
            }

            for (Edge e : adj.get(u)) {

                int v = e.dest;
                int wt = e.wt;

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                long newCost = cost + wt;

                if (newCost < dist[v][newCount]) {

                    dist[v][newCount] = newCost;

                    pq.add(new Pair(v, newCount, newCost));
                }
            }
        }

        return -1;
    }
}