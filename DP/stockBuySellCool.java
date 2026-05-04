// Tabulation Method
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+2][2];
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                int profit=0;
                if(j==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }else{
                    profit=Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][1];
    }
}

// Memoisation Method
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int i=0;i<n+1;i++) Arrays.fill(dp[i],-1);
        return helper(0,1,prices,dp);
    }
    private int helper(int i,int buy,int[] p,int[][] dp){
        if(i>=p.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-p[i]+helper(i+1,0,p,dp),helper(i+1,1,p,dp));
        }else{
            profit=Math.max(p[i]+helper(i+2,1,p,dp),helper(i+1,0,p,dp));
        }
        return dp[i][buy]=profit;
    }
}
