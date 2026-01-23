class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int res=0;
        int i=1;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int prevEnd=intervals[0][1];
        while(i<n){
            if(intervals[i][0]<prevEnd){
                res++;
            }else{
                prevEnd=intervals[i][1];
            }
            i++;
        }
        return res;
    }
}
