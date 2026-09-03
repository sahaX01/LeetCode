class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = Integer.MIN_VALUE;

        for(int x : nums){
            h = Math.max(h, x);
        }

        while(l<=h){
            int mid = l + (h-l)/2;
            int sum = 0;
            for(int x : nums){
                sum += Math.ceil((double)x / mid);
            }

            if(sum>threshold){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }

        return l;
    }
}