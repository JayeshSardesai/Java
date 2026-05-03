class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[2][k+1];
        for(int i=n-1;i>=0;i--){
            int[][] temp=new int[2][k+1];
            for(int j=0;j<2;j++){
                for(int l=1;l<=k;l++){
                    int profit=0;
                    if(j==1){
                        profit=Math.max(-prices[i]+dp[0][l],dp[1][l]);
                    }else{
                        profit=Math.max(prices[i]+dp[1][l-1],dp[0][l]);
                    }
                    temp[j][l]=profit;
                }
            }
            dp=temp;
        }
        return dp[1][k];
    }
}
