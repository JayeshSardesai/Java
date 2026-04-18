// Optimized space Tabulation Method.
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[i]=1;
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[amount+1];
            for(int j=0;j<=amount;j++){
                int miss=dp[j];
                int take=0;
                if(j>=coins[i]) take=temp[j-coins[i]];
                temp[j]=miss+take;
            }
            dp=temp;
        }
        return dp[amount];
    }
}

// Tabulation Method
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int miss=dp[i-1][j];
                int take=0;
                if(j>=coins[i]) take=dp[i][j-coins[i]];
                dp[i][j]=miss+take;
            }
        }
        return dp[n-1][amount];
    }
}

// Memoisation Method.
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,amount,coins,dp);
    }
    private int helper(int i,int amt,int[] coins,int[][] dp){
        if(i==0){
            if(amt==0&&coins[i]==0) return 2;
            if(amt%coins[i]==0||amt==0) return 1;
            return 0;
        }
        if(dp[i][amt]!=-1) return dp[i][amt];
        int miss=helper(i-1,amt,coins,dp);
        int take=0;
        if(amt>=coins[i]){
            take=helper(i,amt-coins[i],coins,dp);
        }
        return dp[i][amt]=miss+take;
    }
}

// Optimal Approach for this problem
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
