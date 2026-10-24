class Solution {
    public static int reversePairs(int nums[], int l, int mid, int r) {
        int pairs = 0;
        int rightPointer = mid + 1;

        for (int leftPointer = l; leftPointer <= mid; leftPointer++) {

            while (rightPointer <= r && nums[leftPointer] > 2L * nums[rightPointer]) {
                rightPointer++;
            }
            pairs = pairs + (rightPointer - (mid + 1));
        }
        return pairs;
    }

    public static void mergeHalf(int nums[], int l, int mid, int r) {
        int merge[] = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                merge[k++] = nums[i++];
            } else {
                merge[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            merge[k++] = nums[i++];
        }
        while (j <= r) {
            merge[k++] = nums[j++];
        }
        for (int x = 0; x < merge.length; x++) {
            nums[l + x] = merge[x];
        }
    }

    public static int mergeSort(int nums[], int l, int r) {
        int pairs = 0;
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;

        pairs += mergeSort(nums, l, mid);
        pairs += mergeSort(nums, mid + 1, r);
        pairs += reversePairs(nums, l, mid, r);
        mergeHalf(nums, l, mid, r);
        return pairs;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}