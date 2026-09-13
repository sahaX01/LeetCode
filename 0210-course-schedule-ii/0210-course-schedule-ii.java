class Solution {
    class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    ArrayList<Integer> a = new ArrayList<>();
    public  void topsort(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length];

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            a.add(curr);

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;

                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
            int V = numCourses;
            ArrayList<Edge> graph[] = new ArrayList[V];
            for(int i=0; i<graph.length; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<prerequisites.length; i++){
                int src = prerequisites[i][1];
                int dest = prerequisites[i][0];

                graph[src].add(new Edge(src, dest));
            }
            topsort(graph);
            
            if(a.size() != V){
                return new int[0];
            }
            int ans[] = new int[V];
            for(int i=0; i<a.size(); i++){
                ans[i] = a.get(i);
            }

            return ans;
    } 
}