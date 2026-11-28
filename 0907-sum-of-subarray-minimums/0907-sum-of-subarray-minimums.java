class Solution {
    // Next Strictly Smaller or Equal Element index
    public int[] findNSE(int arr[]){
        int n = arr.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
              st.pop();
            }
            if(st.isEmpty()){
             nse[i] = n; 
            }else{
             nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    // Previous Strictly Smaller Element index
    public int[] findPSE(int arr[]){
        int n = arr.length;
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
              st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int nse[] = findNSE(arr);
        int pse[] = findPSE(arr);
        long sum = 0;
        long mod = 1000000007;
        for(int i=0; i<arr.length; i++){
            long right = nse[i] - i;
            long left = i - pse[i];
            long contribution = ( right * left * arr[i] ) % mod;
            sum = (sum + contribution) % mod;
        }

        return (int)sum;
    }
}