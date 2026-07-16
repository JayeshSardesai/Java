class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        int maxCnt1 = 0;
        int cnt1 = 0;
        int maxCnt0 = 0;
        int cnt0 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1){
                cnt1++;
                maxCnt0 = Math.max(maxCnt0, cnt0);
                cnt0 = 0;
            }
            else {
                cnt0++;
                maxCnt1 = Math.max(cnt1,maxCnt1);
                cnt1 = 0;
            }
        }
        maxCnt1 = Math.max(maxCnt1, cnt1);
        maxCnt0 = Math.max(maxCnt0, cnt0);
        return Math.max(maxCnt1,maxCnt0);
    }
}
