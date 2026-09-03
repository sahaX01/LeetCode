class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int maxPackage = 0;
        int totalPackage = 0;
        for(int x : weights){
            maxPackage = Math.max(maxPackage, x);
            totalPackage += x;
        }
        int low = maxPackage;
        int high = totalPackage;
        int mid = 0;
        while(low<=high){
           mid = low + (high-low)/2;
           
           int dayNeed = 1;
           int currentWeight = 0;

           for(int w : weights){
            currentWeight += w;
            if(currentWeight>mid){
                dayNeed++;
                currentWeight = w;
            }
           }
           if(dayNeed<=days){
            high = mid - 1;
           }else{
            low = mid + 1;
           }
        }

        return low;
    }
}