// In this approach I have done this for four directions.
class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public void bfs(int ro,int co,int n,int m,char[][] grid,int[][] vis){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<>();
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        q.add(new Pair(ro,co));
        while(!q.isEmpty()){
            int f=q.peek().first;
            int s=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int r=f+row[i];
                int c=s+col[i];
                if(r<n&&r>=0&&c<m&&c>=0&&grid[r][c]=='1'&&vis[r][c]==0){
                    q.add(new Pair(r,c));
                    vis[r][c]=1;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,n,m,grid,vis);
                }
            }
        }
        return cnt;
    }
}

// In this approach I have done this for 8 directions
class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public void bfs(int ro,int co,int n,int m,char[][] grid,int[][] vis){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(ro,co));
        while(!q.isEmpty()){
            int f=q.peek().first;
            int s=q.peek().second;
            q.remove();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int r=f+i;
                    int c=s+j;
                    if(r<n&&r>=0&&c<m&&c>=0&&grid[r][c]=='L'&&vis[r][c]==0){
                        q.add(new Pair(r,c));
                        vis[r][c]=1;
                    }
                }
            }
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='L'){
                    cnt++;
                    bfs(i,j,n,m,grid,vis);
                }
            }
        }
        return cnt;
    }
}
