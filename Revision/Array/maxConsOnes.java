class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCnt = 0;
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) cnt++;
            else {
                maxCnt = Math.max(cnt,maxCnt);
                cnt = 0;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }
}
