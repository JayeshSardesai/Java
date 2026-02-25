class Solution {
    public void dfs(int i,int j,int n,int m,char[][] mat,int[][] vis,int[] row,int[] col){
        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int r=i+row[k];
            int c=j+col[k];
            if(r<n&&r>=0&&c<m&&c>=0&&mat[r][c]=='O'&&vis[r][c]==0){
                dfs(r,c,n,m,mat,vis,row,col);
            }
        }
    }
    public void fill(char[][] grid) {
        // Code here
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<m;i++){
            if(vis[0][i]==0&&grid[0][i]=='O'){
                dfs(0,i,n,m,grid,vis,row,col);
            }
            if(vis[n-1][i]==0&&grid[n-1][i]=='O'){
                dfs(n-1,i,n,m,grid,vis,row,col);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0&&grid[i][0]=='O'){
                dfs(i,0,n,m,grid,vis,row,col);
            }
            if(vis[i][m-1]==0&&grid[i][m-1]=='O'){
                dfs(i,m-1,n,m,grid,vis,row,col);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1) grid[i][j]='X';
            }
        }
    }
}
