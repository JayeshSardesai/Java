// Tabulation Method.
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+2][n+2];
        int[] arr=new int[n+2];
        arr[0]=1;arr[n+1]=1;
        for(int i=1;i<n+1;i++) arr[i]=nums[i-1];
        for(int i=n;i>=1;i--){
            for(int j=i;j<=n;j++){
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int cost=arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(max,cost);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }
}

// Memoisation Method.
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+2][n+2];
        int[] arr=new int[n+2];
        for(int i=0;i<n+2;i++) Arrays.fill(dp[i],-1);
        arr[0]=1;arr[n+1]=1;
        for(int i=1;i<n+1;i++) arr[i]=nums[i-1];
        return helper(1,n,arr,dp);
    }
    private int helper(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost=arr[i-1]*arr[k]*arr[j+1]+helper(i,k-1,arr,dp)+helper(k+1,j,arr,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}
