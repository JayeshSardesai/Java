//Using arraylist
class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        int n=intervals.length;
        ArrayList<int[]> res=new ArrayList<>();
        int i=0;
        while(i<n&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        while(i<n&&intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res.add(newInterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res;
    }
}
//Using arrays
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] res=new int[n+1][2];
        int i=0,k=0;
        while(i<n&&intervals[i][1]<newInterval[0]){
            res[k][0]=intervals[i][0];
            res[k][1]=intervals[i][1];
            i++;k++;
        }
        while(i<n&&intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res[k][0]=newInterval[0];
        res[k][1]=newInterval[1];
        k++;
        while(i<n){
            res[k][0]=intervals[i][0];
            res[k][1]=intervals[i][1];
            i++;k++;
        }
        return Arrays.copyOf(res,k);
    }
}
