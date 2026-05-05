// Optimized Space Tabulation Method.
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[] dp=new int[2];
        dp[0]=dp[1]=0;
        for(int i=n-1;i>=0;i--){
            int[] temp=new int[2];
            for(int j=0;j<2;j++){
                int profit=0;
                if(j==1){
                    profit=Math.max(-prices[i]+dp[0],dp[1]);
                }else{
                    profit=Math.max(prices[i]-fee+dp[1],dp[0]);
                }
                temp[j]=profit;
            }
            dp=temp;
        }
        return dp[1];
    }
}

// Tabulation Method.
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                int profit=0;
                if(j==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }else{
                    profit=Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][1];
    }
}

// Memoisation Method.
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int i=0;i<n+1;i++) Arrays.fill(dp[i],-1);
        return helper(0,1,prices,dp,fee);
    }
    private int helper(int i,int buy,int[] p,int[][] dp,int fee){
        if(i==p.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-p[i]+helper(i+1,0,p,dp,fee),helper(i+1,1,p,dp,fee));
        }else{
            profit=Math.max(p[i]-fee+helper(i+1,1,p,dp,fee),helper(i+1,0,p,dp,fee));
        }
        return dp[i][buy]=profit;
    }
}
