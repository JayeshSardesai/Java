class tuple{
    int a,b,val;
    tuple(int a,int b,int val){
        this.a=a;
        this.b=b;
        this.val=val;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] vis=new int[n][n];
        PriorityQueue<tuple> q=new PriorityQueue<>((a,b)->a.val-b.val);
        q.add(new tuple(0,0,grid[0][0]));
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().a;
            int c=q.peek().b;
            int v=q.peek().val;
            q.remove();
            if(vis[r][c]==1) continue;
            vis[r][c]=1;
            if(r==n-1&&c==n-1) return v;
            for(int i=0;i<4;i++){
                int nr=r+row[i];
                int nc=c+col[i];
                if(nr<n&&nc<n&&nr>=0&&nc>=0){
                    q.add(new tuple(nr,nc,Math.max(v,grid[nr][nc])));
                }
            }
        }
        return -1;
    }
}
