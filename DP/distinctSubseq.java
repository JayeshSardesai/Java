// Optimized Space Tabulation Method.
class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] dp=new int[m+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int[] temp=new int[m+1];
            temp[0]=1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    temp[j]=dp[j-1]+dp[j];
                }else{
                    temp[j]=dp[j];
                }
            }
            dp=temp;
        }
        return dp[m];
    }
}

// Tabulation Method.
class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=1;i<=m;i++) dp[0][i]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}

// Memoisation Method.
class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,m-1,s,t,dp);
    }
    private int helper(int i,int j,String s,String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=(helper(i-1,j-1,s,t,dp)+helper(i-1,j,s,t,dp));
        }
        return dp[i][j]=helper(i-1,j,s,t,dp);
    }
}
