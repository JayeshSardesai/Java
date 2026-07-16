class Solution {
    public int maxPower(String s) {
        int maxCnt = 0;
        int cnt = 1;
        char ch = s.charAt(0);
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if(ch == s.charAt(i)) cnt++;
            else {
                maxCnt = Math.max(cnt, maxCnt);
                cnt = 1;
                ch = s.charAt(i);
            }
        }
        maxCnt = Math.max(maxCnt,cnt);
        return maxCnt;
    }
}
