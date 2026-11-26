class Solution {
    public boolean canAliceWin(int n) {
        int turn = 0;
        int can = 10;

        while(n >= can){
          n = n - can;
          can--;
          turn++;
        }

        if(turn % 2 == 0) return false;
        return true;
    }
}