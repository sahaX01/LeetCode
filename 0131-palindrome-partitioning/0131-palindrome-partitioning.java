class Solution {
    List<List<String>> result = new ArrayList<>();
    int n;

    public boolean Palindrome(String s) {

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public void solve(int i, String s, List<String> ll) {
        if (i == n) {
            result.add(new ArrayList<>(ll));
            return;
        }
        for (int j = i; j < n; j++) {
            String str = s.substring(i, j + 1);
            if (Palindrome(str)) {

                ll.add(str);

                solve(j + 1, s, ll);
                ll.remove(ll.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        solve(0, s, new ArrayList<>());

        return result;
    }
}