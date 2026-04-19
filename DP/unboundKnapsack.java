// Optimized Space Tabulation Method.
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        int[] dp=new int[capacity+1];
        for(int i=0;i<=capacity;i++){
            if(wt[0]<=i) dp[i]=(i/wt[0])*val[0];
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[capacity+1];
            for(int j=0;j<=capacity;j++){
                int miss=dp[j];
                int take=0;
                if(wt[i]<=j) take=val[i]+temp[j-wt[i]];
                temp[j]=Math.max(miss,take);
            }
            dp=temp;
        }
        return dp[capacity];
    }
}

// Tabulation Method.
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        int[][] dp=new int[n][capacity+1];
        for(int i=0;i<=capacity;i++){
            if(wt[0]<=i) dp[0][i]=(i/wt[0])*val[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=capacity;j++){
                int miss=dp[i-1][j];
                int take=0;
                if(wt[i]<=j) take=val[i]+dp[i][j-wt[i]];
                dp[i][j]=Math.max(miss,take);
            }
        }
        return dp[n-1][capacity];
    }
}

// Memoisation Method.
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        int[][] dp=new int[n][capacity+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,val,wt,capacity,dp);
    }
    private int helper(int i,int[] v,int[] w,int cap,int[][] dp){
        if(i==0){
            return (cap/w[i])*v[i];
        }
        if(dp[i][cap]!=-1) return dp[i][cap];
        int miss=helper(i-1,v,w,cap,dp);
        int take=0;
        if(cap>=w[i]) take=v[i]+helper(i,v,w,cap-w[i],dp);
        return dp[i][cap]=Math.max(miss,take);
    }
}
