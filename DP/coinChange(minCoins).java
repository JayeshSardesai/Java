// Optimized Tabulation Method.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[i]=i/coins[0];
            else dp[i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[amount+1];
            for(int j=0;j<=amount;j++){
                int miss=dp[j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j&&temp[j-coins[i]]!=Integer.MAX_VALUE) take=1+temp[j-coins[i]];
                temp[j]=Math.min(miss,take);
            }
            dp=temp;
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}

// Tabulation Method.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int miss=dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j&&dp[i][j-coins[i]]!=Integer.MAX_VALUE) take=1+dp[i][j-coins[i]];
                dp[i][j]=Math.min(miss,take);
            }
        }
        return dp[n-1][amount]==Integer.MAX_VALUE?-1:dp[n-1][amount];
    }
}

// Memoisation Method.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans=helper(n-1,amount,coins,dp);
        return ans>=(int)1e9?-1:ans;
    }
    private int helper(int i,int tr,int[] c,int[][] dp){
        if(i==0){
            if(tr%c[i]==0) return tr/c[i];
            else return (int)1e9;
        }
        if(dp[i][tr]!=-1) return dp[i][tr];
        int miss=helper(i-1,tr,c,dp);
        int take=Integer.MAX_VALUE;
        if(c[i]<=tr) take=1+helper(i,tr-c[i],c,dp);
        return dp[i][tr]=Math.min(miss,take);
    }
}
