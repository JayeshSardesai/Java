class Pair{
    int row,col,tm;
    Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRot(int[][] grid) {
        // code here
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=grid[i][j];
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int cnt=0;
        int tm=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            q.remove();
            tm=Math.max(tm,t);
            for(int i=0;i<4;i++){
                int newr=r+drow[i];
                int newc=c+dcol[i];
                if(newr>=0&&newr<n&&newc>=0&&newc<m&&vis[newr][newc]!=0&&vis[newr][newc]==1){
                    q.add(new Pair(newr,newc,t+1));
                    vis[newr][newc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=fresh) return -1;
        return tm;
    }
}
