class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        Stack<Character> st = new Stack<>();
        int k = 0;
        int a[] = new int[seq.length()];
        int depth = 0;
        for(int i=0; i<seq.length(); i++){
          char ch = seq.charAt(i);
          
          if(ch == '('){
            depth++;
            a[k++] = depth % 2;
          }else{
            a[k++] = depth % 2;
            depth--;
          }
        }

        return a;
    }
}