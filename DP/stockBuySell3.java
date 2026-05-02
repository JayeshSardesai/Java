// Optimized Space Tabulation Method.
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[2][3];
        for(int i=n-1;i>=0;i--){
            int[][] temp=new int[2][3];
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++){
                    int profit=0;
                    if(j==1){
                        profit=Math.max(-prices[i]+dp[0][k],dp[1][k]);
                    }else{
                        profit=Math.max(prices[i]+dp[1][k-1],dp[0][k]);
                    }
                    temp[j][k]=profit;
                }
            }
            dp=temp;
        }
        return dp[1][2];
    }
}

// Tabulation Method.
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++){
                    int profit=0;
                    if(j==1){
                        profit=Math.max(-prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
                    }else{
                        profit=Math.max(prices[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
                    }
                    dp[i][j][k]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
}

// Memoisation Method.
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++)
                Arrays.fill(dp[i][j],-1);
        } 
        return helper(0,1,prices,dp,2);
    }
    private int helper(int i,int buy,int[] p,int[][][] dp,int cap){
        if(i==p.length) return 0;
        if(cap==0) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit=0;
        if(buy==1){
            profit=Math.max(-p[i]+helper(i+1,0,p,dp,cap),helper(i+1,1,p,dp,cap));
        }else{
            profit=Math.max(p[i]+helper(i+1,1,p,dp,cap-1),helper(i+1,0,p,dp,cap));
        }
        return dp[i][buy][cap]=profit;
    }
}
