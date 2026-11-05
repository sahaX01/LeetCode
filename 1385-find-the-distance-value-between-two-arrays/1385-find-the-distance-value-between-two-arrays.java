class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        int n1 = arr1.length;
        int n2 = arr2.length;

        for (int i = 0; i < n1; i++) {
            int j = 0;
            boolean flag = true;
            while (j < n2) {
                int val = Math.abs(arr1[i] - arr2[j]);
                if (val <= d) {
                    flag = false;
                    break;
                }
                j++;
            }
            if (flag) {
                distance++;
            }
        }

        return distance;
    }
}