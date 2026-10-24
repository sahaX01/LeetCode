class Solution {
    static int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int find(int month, String day){
        int total = Integer.parseInt(day);
        for(int i=1; i<month; i++){
            total += days[i];
        }
        return total;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int aARm = Integer.parseInt(arriveAlice.substring(0, 2));
        int alm = Integer.parseInt(leaveAlice.substring(0, 2));
        int bARm = Integer.parseInt(arriveBob.substring(0, 2));
        int blm = Integer.parseInt(leaveBob.substring(0, 2));

        int aARd = find(aARm, arriveAlice.substring(3));
        int ald = find(alm, leaveAlice.substring(3));
        int bARd = find(bARm, arriveBob.substring(3));
        int bld = find(blm, leaveBob.substring(3));
        
        if(ald < bARd || bld < aARd) return 0;
        return Math.min(ald, bld) - Math.max(aARd, bARd) + 1;

    }
}