class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        while(true){
          if(!set.contains(n)){
            set.add(n);
          }else{
            break;
          }
          
          int sum = 0;
          while(n > 0){
            int rem = n % 10;
            sum += (rem * rem);
            n = n / 10;
          }   
          n = sum;
          if(n == 1){
            break;
          }
        }

        return n==1;
    }
}