import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        Set<String> set = new HashSet<>();

        int leftRemove = 0;
        int rightRemove = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftRemove++;
            } 
            else if (ch == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } 
                else {
                    rightRemove++;
                }
            }
        }

        backtrack(s, 0, 0, 0, leftRemove, rightRemove, "", set);

        return new ArrayList<>(set);
    }

    public void backtrack(String s, int index, int open, int close,
                          int leftRemove, int rightRemove,
                          String current, Set<String> set) {

        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                open == close) {

                set.add(current);
            }

            return;
        }

        char ch = s.charAt(index);

        // Remove '('
        if (ch == '(' && leftRemove > 0) {
            backtrack(s, index + 1,
                    open, close,
                    leftRemove - 1,
                    rightRemove,
                    current,
                    set);
        }

        // Remove ')'
        if (ch == ')' && rightRemove > 0) {
            backtrack(s, index + 1,
                    open, close,
                    leftRemove,
                    rightRemove - 1,
                    current,
                    set);
        }

        // Keep character
        if (ch != '(' && ch != ')') {

            backtrack(s, index + 1,
                    open, close,
                    leftRemove, rightRemove,
                    current + ch,
                    set);

        }
        // Keep '('
        else if (ch == '(') {

            backtrack(s, index + 1,
                    open + 1, close,
                    leftRemove, rightRemove,
                    current + ch,
                    set);
        }
        // Keep ')'
        else {

            if (open > close) {

                backtrack(s, index + 1,
                        open, close + 1,
                        leftRemove, rightRemove,
                        current + ch,
                        set);
            }
        }
    }
}