class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        
        int n = s.length();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch =='('){
                minOpen++;
                maxOpen++;
            }else if(ch ==')'){
                minOpen--;
                maxOpen--;
            }else{ // *
            minOpen--; // use * as )
            maxOpen++; // use * as (
            }

            if(minOpen<0){
                minOpen = 0;
            }

            if(maxOpen < 0){
                return false;
            }
        }
        return minOpen == 0;
    }
}