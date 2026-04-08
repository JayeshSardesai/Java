// Optimized tabulation method.
class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) dp[j1][j2]=grid[n-1][j1];
                else dp[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        for(int i=n-2;i>=0;i--){
            int[][] temp=new int[m][m];
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int max=(int)-1e8;
                    for(int k1=-1;k1<=1;k1++){
                        for(int k2=-1;k2<=1;k2++){
                            if(j1+k1>=0&&j2+k2>=0&&j1+k1<m&&j2+k2<m)
                                max=Math.max(max,dp[j1+k1][j2+k2]);
                        }
                    }
                    if(j1==j2) temp[j1][j2]=grid[i][j1]+max;
                    else temp[j1][j2]=grid[i][j1]+grid[i][j2]+max;
                }
            }
            dp=temp;
        }
        return dp[0][m-1];
    }
}

// Tabulation method.
class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) dp[n-1][j1][j2]=grid[n-1][j1];
                else dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int max=(int)-1e8;
                    for(int k1=-1;k1<=1;k1++){
                        for(int k2=-1;k2<=1;k2++){
                            if(j1+k1>=0&&j2+k2>=0&&j1+k1<m&&j2+k2<m)
                                max=Math.max(max,dp[i+1][j1+k1][j2+k2]);
                        }
                    }
                    if(j1==j2) dp[i][j1][j2]=grid[i][j1]+max;
                    else dp[i][j1][j2]=grid[i][j1]+grid[i][j2]+max;
                }
            }
        }
        return dp[0][0][m-1];
    }
}

// Memoisation method.
class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,0,m-1,grid,dp);
    }
    private int helper(int i,int j1,int j2,int[][] grid,int[][][] dp){
        if(j1<0||j2<0||j1>=grid[0].length||j2>=grid[0].length) return (int)-1e8;
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        if(i==grid.length-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int max=Integer.MIN_VALUE;
        for(int k1=-1;k1<=1;k1++){
            for(int k2=-1;k2<=1;k2++){
                max=Math.max(max,helper(i+1,j1+k1,j2+k2,grid,dp));
            }
        }
        if(j1==j2) return dp[i][j1][j2]=grid[i][j1]+max;
        return dp[i][j1][j2]=grid[i][j1]+grid[i][j2]+max;
    }
}
