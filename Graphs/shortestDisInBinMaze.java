// In this it is allowed to go 4 directions.

// User function Template for Java
class tuple{
    int fir,sec,thr;
    tuple(int fir,int sec,int thr){
        this.fir=fir;
        this.sec=sec;
        this.thr=thr;
    }
}
class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Your code here
        if(grid[source[0]][source[1]]==0) return -1;
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        Queue<tuple> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[source[0]][source[1]]=0;
        q.add(new tuple(0,source[0],source[1]));
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!q.isEmpty()){
            int d=q.peek().fir;
            int r=q.peek().sec;
            int c=q.peek().thr;
            q.remove();
            if(r==destination[0]&&c==destination[1]) return d;
            for(int i=0;i<4;i++){
                int newr=r+row[i];
                int newc=c+col[i];
                if(newr<n&&newr>=0&&newc<m&&newc>=0&&grid[newr][newc]==1&&1+d<dist[newr][newc]){
                    dist[newr][newc]=1+d;
                    q.add(new tuple(dist[newr][newc],newr,newc));
                }
            }
        }
        return -1;
    }
}

// In this it is allowed to move to 8 directions and moving is done if cell value is 0.

class tuple{
    int fir,sec,thr;
    tuple(int fir,int sec,int thr){
        this.fir=fir;
        this.sec=sec;
        this.thr=thr;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n=grid.length;
        int[][] dist=new int[n][n];
        Queue<tuple> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        q.add(new tuple(1,0,0));
        while(!q.isEmpty()){
            int d=q.peek().fir;
            int r=q.peek().sec;
            int c=q.peek().thr;
            q.remove();
            if(r==n-1&&c==n-1) return d;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int newr=r+i;
                    int newc=c+j;
                    if(i==0&&j==0) continue;
                    if(newr<n&&newr>=0&&newc<n&&newc>=0&&grid[newr][newc]==0&&1+d<dist[newr][newc]){
                        dist[newr][newc]=1+d;
                        q.add(new tuple(dist[newr][newc],newr,newc));
                    }
                }
            }
        }
        return -1;
    }
}
