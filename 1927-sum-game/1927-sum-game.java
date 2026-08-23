class Solution {
    public boolean sumGame(String num) {
        int len = num.length();
        int leftsum = 0;
        int rightsum = 0;
        int lq = 0;
        int rq = 0;
        for (int i = 0; i < len / 2; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                lq++;
            } else {
                leftsum += (ch - '0');
            }
        }
        for (int i = len / 2; i < len; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                rq++;
            } else {
                rightsum += (ch - '0');
            }

        }
        int totalq = lq + rq;
        if(totalq % 2 == 1){
            return true;
        }

        int diff = leftsum - rightsum;

        return diff != 9 * (rq-lq)/2;
    }
}