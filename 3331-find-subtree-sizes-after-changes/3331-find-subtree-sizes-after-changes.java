class Solution {
    int n;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    HashMap<Character, Integer> map = new HashMap<>();
    int answer[];
    int Pos[];

    public void createGraph(int[] parent){
      for(int i=0; i<n; i++){
        int val = parent[i];
        if(val != -1){
            graph.get(val).add(i);
        }
      }
    }

    public void dfs(int node, String str, int par){
      for(int child : graph.get(node)){
        par = node;
        char ch = str.charAt(child);
        Integer old = map.get(ch);

        if(old != null){
            Pos[child] = old;
        }
        map.put(ch, child);
        dfs(child, str, node);

        if(old != null){
            map.put(ch, old);
        }else{
            map.remove(ch);
        }
      }
      return;
    }
    
    public int countSize(int node){
        int size = 1;
      for(int child : graph.get(node)){
        size += countSize(child);
      }
      answer[node] = size;
      return size;
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        n = parent.length;
        answer = new int[n];
        Pos = parent.clone();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        createGraph(parent);
        map.put(s.charAt(0), 0);
        dfs(0, s, -1);
        graph.clear();
         for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        createGraph(Pos);
        countSize(0);

        return answer;
    }
}