class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (!set.contains(x)) {
                set.add(x);
            } else {
                set.remove(x);
            }
        }

        int arr[] = new int[set.size()];
        int k = 0;
        for (int key : set) {
            arr[k++] = key;
        }

        return arr;
    }
}