class Solution {
    public boolean checkString(String s) {
        int drop = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                drop++;
            }
        }
        return drop == 0;
    }
}
