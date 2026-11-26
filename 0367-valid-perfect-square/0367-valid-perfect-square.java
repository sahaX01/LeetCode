class Solution {
    public boolean isPerfectSquare(int num) {
        int n = num;

        int l = 1;
        int h = num;

        while(l<=h){
            int mid = (l+h) / 2;
            
            
            if(mid == n / mid && n % mid == 0){
                return true;
            }else if(mid > n / mid ){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return false;
    }
}