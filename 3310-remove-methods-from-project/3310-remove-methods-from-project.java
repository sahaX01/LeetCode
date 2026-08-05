class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // create graph first
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
          graph.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        boolean suspisious[] = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        suspisious[k] = true;

        while(!q.isEmpty()){
            int curr = q.remove();
            for(int next : graph.get(curr)){
                // Remove edge curr -> next
                indegree[next]--;
                if(!suspisious[next]){
                    suspisious[next] = true;
                    q.add(next);
                }
            }
        }
        // If a suspicious node still has indegree,
        // it means a non-suspicious node points to it.
        
        boolean cantRemove = false;

        for(int i=0; i<n; i++){
            if(suspisious[i] && indegree[i]>0){
                cantRemove = true;
                break;
            }
        }
         List<Integer> ans = new ArrayList<>();

         // cannot remove 
         if(cantRemove){
            for(int i=0; i<n; i++){
                ans.add(i);
            }
            return ans;
         }

         // can remove
         for(int i=0; i<n; i++){
            if(!suspisious[i]){
                ans.add(i);
            }
         }
         return ans;
    }
}