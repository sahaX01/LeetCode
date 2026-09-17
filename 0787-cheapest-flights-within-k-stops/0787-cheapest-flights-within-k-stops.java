class Solution {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int u, int v, int d){
            this.src = u;
            this.dest = v;
            this.wt = d;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[], int[][] flights){
       for(int i=0; i<flights.length; i++){
        int src = flights[i][0];
        int dest = flights[i][1];
        int wt = flights[i][2];
        graph[src].add(new Edge(src, dest, wt));
       }
    }
    class Info{
        int src;
        int cost;
        int stops;
        public Info(int src, int cost, int stops){
            this.src = src;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList();
        }
        creategraph(graph, flights);
        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr.stops>k){
                break;
            }

            for(int i=0; i<graph[curr.src].size(); i++){
                Edge e = graph[curr.src].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < ans[v] && curr.stops <=k){
                    ans[v] = curr.cost + wt;
                    q.add(new Info(v, ans[v], curr.stops+1));
                }
            }
        }

        if(ans[dst] == Integer.MAX_VALUE){
            return -1;
        }

        return ans[dst];
    }
}