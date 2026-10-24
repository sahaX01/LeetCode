class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        for(int i=1; i<nums.length; i++){
            int currentValue = nums[i];
            int previousMax = currentMax;
            int previousMin = currentMin;

            currentMax = Math.max(currentValue,
            (Math.max(previousMax * currentValue, previousMin * currentValue)));
            
            currentMin = Math.min(currentValue,
            Math.min(previousMax * currentValue, previousMin * currentValue));

            if(currentMax > maxProduct){
                maxProduct = currentMax;
            }
            
        }
        return maxProduct;
    }
}