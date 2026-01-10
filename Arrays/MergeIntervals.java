class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[][] arr=new int[intervals.length][2];
        int k=0;
        for(int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(k==0||arr[k-1][1]<start){
                arr[k][0]=start;
                arr[k++][1]=end;
            }else{
                arr[k-1][1]=Math.max(arr[k-1][1],end);
            }
        }
        return Arrays.copyOfRange(arr,0,k);
    }
}
