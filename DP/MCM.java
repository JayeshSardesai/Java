// Tabulation Method.
class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        long[][] dp=new long[n][n];
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                long min=Long.MAX_VALUE;
                for(int k=i;k<j;k++){
                    long step=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    min=Math.min(step,min);
                }
                dp[i][j]=min;
            }
        }
        return (int)dp[1][n-1];
    }
}

// Memoisation Method.
class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(1,n-1,arr,dp);
    }
    static int helper(int i,int j,int[] arr,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=(int)1e9;
        for(int k=i;k<j;k++){
            int step=arr[i-1]*arr[k]*arr[j]+helper(i,k,arr,dp)+helper(k+1,j,arr,dp);
            min=Math.min(step,min);
        }
        return dp[i][j]=min;
    }
}
