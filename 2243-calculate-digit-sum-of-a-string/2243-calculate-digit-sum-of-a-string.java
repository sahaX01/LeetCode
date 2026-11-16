
class Solution {
    public String digitSum(String s, int k) {
        int len = s.length();

        while(len > k) {
            String temp = "";

            for(int i = 0; i < len; i += k) {
                int sum = 0;

                for(int j = i; j < Math.min(i + k, len); j++) {
                    sum += s.charAt(j) - '0';
                }

                temp += sum;
            }

            s = temp;
            len = s.length();
        }

        return s;
    }
}
