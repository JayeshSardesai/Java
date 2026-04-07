// Optimized tabulation method.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                int down=dp[j];
                int dl=Integer.MAX_VALUE;
                if(j>0) dl=dp[j-1];
                int dr=Integer.MAX_VALUE;
                if(j<n-1) dr=dp[j+1];
                temp[j]=matrix[i][j]+Math.min(down,Math.min(dr,dl));
            }
            dp=temp;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[i]);
        }
        return min;
    }
}

// Tabulation method.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int down=dp[i+1][j];
                int dl=Integer.MAX_VALUE;
                if(j>0) dl=dp[i+1][j-1];
                int dr=Integer.MAX_VALUE;
                if(j<n-1) dr=dp[i+1][j+1];
                dp[i][j]=matrix[i][j]+Math.min(down,Math.min(dr,dl));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[0][i]);
        }
        return min;
    }
}

// Memoisation method.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,helper(0,i,matrix,dp));
        }
        return min;
    }
    private int helper(int i,int j,int[][] matrix,int[][] dp){
        if(i==matrix.length-1) return matrix[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int dl=Integer.MAX_VALUE,dr=Integer.MAX_VALUE;
        if(j>0) dl=helper(i+1,j-1,matrix,dp);
        if(j<matrix.length-1) dr=helper(i+1,j+1,matrix,dp);
        int down=helper(i+1,j,matrix,dp);
        int ans=Math.min(Math.min(dl,dr),down);
        return dp[i][j]=matrix[i][j]+ans; 
    }
}
