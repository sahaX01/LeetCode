class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[] = new int[graph.length];

        for(int i=0; i<col.length; i++){
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++){
          if(col[i] == -1){
            q.add(i);
            col[i] = 0;

            while(!q.isEmpty()){
                int curr = q.remove();

                for(int neighbour : graph[curr]){
                    if(col[neighbour] == -1){
                        int nextCol = col[curr] == 0 ? 1 : 0;
                        col[neighbour] = nextCol;
                        q.add(neighbour); 
                    }else if(col[neighbour] == col[curr]){
                        return false;
                    }
                }
            }
          }
        }
        return true;
    }
}