// Memoisation method
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        return helper(m-1,n-1,dp);
    }
    private int helper(int m,int n,int[][] dp){
        if(m==0&&n==0) return 1;
        if(m<0||n<0) return 0;
        if(dp[m][n]!=0) return dp[m][n];
        int up=helper(m-1,n,dp);
        int left=helper(m,n-1,dp);
        return dp[m][n]=up+left;
    }
}

// Tabulation method.
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j]=1;
                else{
                    int up=0,left=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// Optimized space using Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0&&j==0) temp[j]=1;
                else{
                    int up=0,left=0;
                    up=dp[j];
                    if(j>0) left=temp[j-1];
                    temp[j]=up+left;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}

