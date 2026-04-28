// Optimized Space Tabulation Method
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] dp=new int[m+1];
        for(int i=0;i<=m;i++) dp[i]=i;
        for(int i=1;i<=n;i++){
            int[] temp=new int[m+1];
            temp[0]=i;
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) temp[j]=dp[j-1];
                else temp[j]=1+Math.min(dp[j],Math.min(temp[j-1],dp[j-1]));
            }
            dp=temp;
        }
        return dp[m];
    }
}

// Tabulation Method.
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=i;
        for(int i=0;i<=m;i++) dp[0][i]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[n][m];
    }
}

// Memoisation Method.
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,m-1,word1,word2,dp);
    }
    private int helper(int i,int j,String s1,String s2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=helper(i-1,j-1,s1,s2,dp);
        return dp[i][j]=1+Math.min(helper(i-1,j,s1,s2,dp),Math.min(helper(i,j-1,s1,s2,dp),helper(i-1,j-1,s1,s2,dp)));
    }
}
