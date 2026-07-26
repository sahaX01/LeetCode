class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums3[] = new int[m+n];
        
        int i=0, j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<m){
            nums3[k] = nums1[i];
            i++;
            k++;
        }

        while(j<n){
            nums3[k] = nums2[j];
            j++;
            k++;
        }

        for(i=0; i<nums3.length; i++){
            nums1[i] = nums3[i];
        }
    }
}