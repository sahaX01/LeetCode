class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ll = new ArrayList<>();
        long ans = 1;
        ll.add(1);
        for(int i=0; i<rowIndex; i++){
            ans = ans *(rowIndex-i);
            ans = ans /(i+1);
            ll.add((int)ans);
        }
        return ll;
    }
}