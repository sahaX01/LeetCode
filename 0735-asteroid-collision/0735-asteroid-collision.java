class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            int x = asteroids[i];
            if (x > 0) {
                st.push(x);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(x)) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(x)) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(x);
                }
            }
        }

        if (st.size() == 0)
            return new int[] {};

        int answer[] = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }

        return answer;
    }
}