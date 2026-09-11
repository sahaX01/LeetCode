class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int answer[] = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> st = new Stack<>();
        int i=0;
        for(; i<2*n; i++){
            int curr = i % n;
            while(!st.isEmpty() && nums[curr]> nums[st.peek()]){
                int idx = st.pop();
                answer[idx] = nums[curr];
            }
            if(i<n){
                st.push(i);
            }
        }
        
        return answer;
    }
}