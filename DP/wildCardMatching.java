// Optimized Space Tabulation Method.
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[] dp=new int[m+1];
        dp[0]=1;
        for(int i=1;i<=m;i++){
            if(p.charAt(i-1)=='*') dp[i]=dp[i-1];
            else dp[i]=0;
        }
        for(int i=1;i<=n;i++){
            int[] temp=new int[m+1];
            for(int j=1;j<=m;j++){
                if((s.charAt(i-1)==p.charAt(j-1))||(p.charAt(j-1)=='?')) temp[j]=dp[j-1];
                else if(p.charAt(j-1)=='*') temp[j]=(dp[j]==1||temp[j-1]==1)?1:0;
                else temp[j]=0;
            }
            dp=temp;
        }
        return dp[m]==1;
    }
}

// Tabulation Method.
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            dp[i][0]=0;
        }
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            if(p.charAt(i-1)=='*') dp[0][i]=dp[0][i-1];
            else dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((s.charAt(i-1)==p.charAt(j-1))||(p.charAt(j-1)=='?')) dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*') dp[i][j]=(dp[i-1][j]==1||dp[i][j-1]==1)?1:0;
                else dp[i][j]=0;
            }
        }
        return dp[n][m]==1;
    }
}

// Memoisation method.
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,m-1,s,p,dp);
    }
    private boolean helper(int i,int j,String s,String p,int[][] dp){
        if(i<0&&j<0) return true;
        if(i>=0&&j<0) return false;
        if(i<0&&j>=0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        boolean ans=false;
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?') ans=helper(i-1,j-1,s,p,dp);
        else if(p.charAt(j)=='*') ans=helper(i-1,j,s,p,dp)||helper(i,j-1,s,p,dp);
        dp[i][j]=ans?1:0;
        return ans;
    }
}
