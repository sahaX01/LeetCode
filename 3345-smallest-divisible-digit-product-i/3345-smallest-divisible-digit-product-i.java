class Solution {
    public int smallestNumber(int n, int t) {

        while(true){
            int num = n;
            int product = 1;
            while(num>0){
                int rem = num % 10;
                product *= rem;
                num /= 10;
            }
            if(product % t == 0) return n;
            else n++;
        }
    }
}