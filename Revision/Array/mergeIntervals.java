class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int j = 0;
        ans[0][0] = intervals[0][0];
        ans[0][1] = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int prevEnd = ans[j][1];
            int curStart = intervals[i][0];
            if (prevEnd >= curStart) {
                ans[j][1] = ans[j][1] > intervals[i][1]? ans[j][1]:intervals[i][1];
            } else {
                j++;
                ans[j][0] = intervals[i][0];
                ans[j][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(ans, j+1);
    }
}
