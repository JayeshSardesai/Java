
class tuple{
    int fir,sec,thr;
    tuple(int fir,int sec,int thr){
        this.fir=fir;
        this.sec=sec;
        this.thr=thr;
    }
}
class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<tuple> q=new PriorityQueue<>((a,b)->a.thr-b.thr);
        dist[0][0]=0;
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        q.add(new tuple(0,0,0));
        while(!q.isEmpty()){
            tuple t=q.peek();
            int r=t.fir;
            int c=t.sec;
            int diff=t.thr;
            q.remove();
            if(r==n-1&&c==m-1) return diff;
            for(int i=0;i<4;i++){
                int newr=r+row[i];
                int newc=c+col[i];
                if(newr<n&&newr>=0&&newc<m&&newc>=0){
                    int newdiff=Math.max(diff,Math.abs(mat[r][c]-mat[newr][newc]));
                    if(newdiff<dist[newr][newc]){
                        dist[newr][newc]=newdiff;
                        q.add(new tuple(newr,newc,newdiff));
                    }
                }
            }
        }
        return 0;
    }
}
