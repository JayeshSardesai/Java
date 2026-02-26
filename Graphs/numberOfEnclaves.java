// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        for(int i=0;i<m;i++){
            if(grid[0][i]==1&&vis[0][i]==0){
                dfs(grid,vis,row,col,0,i,n,m);
            }
            if(grid[n-1][i]==1&&vis[n-1][i]==0){
                dfs(grid,vis,row,col,n-1,i,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][0]==1&&vis[i][0]==0){
                dfs(grid,vis,row,col,i,0,n,m);
            }
            if(grid[i][m-1]==1&&vis[i][m-1]==0){
                dfs(grid,vis,row,col,i,m-1,n,m);
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&grid[i][j]==1) res++;
            }
        }
        return res;
    }
    public void dfs(int[][] mat,int[][] vis,int[] row,int[] col,int i,int j,int n,int m){
        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int r=i+row[k];
            int c=j+col[k];
            if(r<n&&r>=0&&c<m&&c>=0&&vis[r][c]==0&&mat[r][c]==1){
                dfs(mat,vis,row,col,r,c,n,m);
            }
        }
    }
}
