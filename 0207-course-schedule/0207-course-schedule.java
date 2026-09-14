class Solution {
    class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public boolean isCycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph, vis, stack, i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean vis[], boolean stack[], int curr){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                if(isCycleUtil(graph, vis, stack, e.dest)){
                    return true;
                }   
            }else if(stack[e.dest]){
                return true;
            }
        }
            stack[curr] = false;
            return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<prerequisites.length; i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];

            graph[src].add(new Edge(src, dest));
        }

        return !isCycle(graph);
    }
}