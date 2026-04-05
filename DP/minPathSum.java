// Optimized tabulation method.
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] dp=new int[n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0&&j==0) temp[j]=grid[i][j];
                else{
                    int up=(i>0)?dp[j]:Integer.MAX_VALUE;
                    int left=(j>0)?temp[j-1]:Integer.MAX_VALUE;
                    int res=Math.min(up,left);
                    if(res==Integer.MAX_VALUE) temp[j]=res;
                    else temp[j]=grid[i][j]+res;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}

// Tabulation method.
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j]=grid[i][j];
                else{
                    int up=(i>0)?dp[i-1][j]:Integer.MAX_VALUE;
                    int left=(j>0)?dp[i][j-1]:Integer.MAX_VALUE;
                    int res=Math.min(up,left);
                    if(res==Integer.MAX_VALUE) dp[i][j]=res;
                    dp[i][j]=grid[i][j]+res;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// Memoisation method.
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return helper(m-1,n-1,grid,dp);
    }
    private int helper(int m,int n,int[][] grid,int[][] dp){
        if(m==0&&n==0) return grid[0][0];
        if(m<0||n<0) return Integer.MAX_VALUE;
        if(dp[m][n]!=-1) return dp[m][n];
        int up=helper(m-1,n,grid,dp);
        int left=helper(m,n-1,grid,dp);
        int res=Math.min(up,left);
        if(res==Integer.MAX_VALUE) return dp[m][n]=res;
        return dp[m][n]=grid[m][n]+res;
    }
}
