// Optimized tabulation method.
class Solution {
    public int maximumPath(int[][] matrix) {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        int[] dp=new int[m];
        for(int i=0;i<m;i++){
            dp[i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                int down=dp[j];
                int dl=Integer.MIN_VALUE;
                if(j>0) dl=dp[j-1];
                int dr=Integer.MIN_VALUE;
                if(j<m-1) dr=dp[j+1];
                temp[j]=matrix[i][j]+Math.max(down,Math.max(dr,dl));
            }
            dp=temp;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
// Tabulation method.
class Solution {
    public int maximumPath(int[][] matrix) {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<m;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int down=dp[i+1][j];
                int dl=Integer.MIN_VALUE;
                if(j>0) dl=dp[i+1][j-1];
                int dr=Integer.MIN_VALUE;
                if(j<m-1) dr=dp[i+1][j+1];
                dp[i][j]=matrix[i][j]+Math.max(down,Math.max(dr,dl));
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[0][i]);
        }
        return max;
    }
}
// Memoisation method.
class Solution {
    public int maximumPath(int[][] matrix) {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max=Math.max(max,helper(0,i,matrix,dp));
        }
        return max;
    }
    private int helper(int i,int j,int[][] matrix,int[][] dp){
        if(i==matrix.length-1) return matrix[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int dl=Integer.MIN_VALUE,dr=Integer.MIN_VALUE;
        if(j>0) dl=helper(i+1,j-1,matrix,dp);
        if(j<matrix[0].length-1) dr=helper(i+1,j+1,matrix,dp);
        int down=helper(i+1,j,matrix,dp);
        int ans=Math.max(Math.max(dl,dr),down);
        return dp[i][j]=matrix[i][j]+ans;
    }
}
