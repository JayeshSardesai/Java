// Optimized Space Tabulation Method.
class Solution {
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++) dp[i]=i*price[0];
        for(int i=1;i<n;i++){
            int[] temp=new int[n+1];
            for(int j=0;j<=n;j++){
                int miss=dp[j];
                int take=0;
                if((i+1)<=j) take=price[i]+temp[j-(i+1)];
                temp[j]=Math.max(take,miss);
            }
            dp=temp;
        }
        return dp[n];
    }
}

// Tabulation Method.
class Solution {
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<=n;i++) dp[0][i]=i*price[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int miss=dp[i-1][j];
                int take=0;
                if((i+1)<=j) take=price[i]+dp[i][j-(i+1)];
                dp[i][j]=Math.max(take,miss);
            }
        }
        return dp[n-1][n];
    }
}

// Memoisation Method.
class Solution {
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,n,price,dp);
    }
    private int helper(int i,int n,int[] p,int[][] dp){
        if(i==0) return n*p[0];
        if(dp[i][n]!=-1) return dp[i][n];
        int miss=helper(i-1,n,p,dp);
        int take=0;
        if((i+1)<=n) take=p[i]+helper(i,n-(i+1),p,dp);
        return dp[i][n]=Math.max(miss,take);
    }
}
