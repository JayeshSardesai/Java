// Tabulation Method.
class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[][] dp=new int[m+2][m+2];
        Arrays.sort(cuts);
        int[] arr=new int[m+2];
        arr[0]=0;arr[m+1]=n;
        for(int i=1;i<m+1;i++) arr[i]=cuts[i-1];
        for(int i=m;i>=1;i--){
            for(int j=i;j<=m;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cs=arr[j+1]-arr[i-1]+dp[i][k-1]+dp[k+1][j];
                    min=Math.min(min,cs);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][m];
    }
}

// Memoisation Method.
class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[][] dp=new int[m+2][m+2];
        for(int i=0;i<m+2;i++) Arrays.fill(dp[i],-1);
        Arrays.sort(cuts);
        int[] arr=new int[m+2];
        arr[0]=0;arr[m+1]=n;
        for(int i=1;i<m+1;i++) arr[i]=cuts[i-1];
        return helper(1,m,arr,dp);
    }
    private int helper(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cs=arr[j+1]-arr[i-1]+helper(i,k-1,arr,dp)+helper(k+1,j,arr,dp);
            min=Math.min(min,cs);
        }
        return dp[i][j]=min;
    }
}
