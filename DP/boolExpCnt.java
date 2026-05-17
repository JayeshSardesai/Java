// User function Template for Java
class Solution {
    static int countWays(String s) {
        // code here
        int n=s.length();
        int[][][] dp=new int[n][n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                Arrays.fill(dp[i][j],-1);
        return helper(0,n-1,s,dp,1);
    }
    static int helper(int i,int j,String s,int[][][] dp,int isTrue){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1){
                return s.charAt(i)=='T'?1:0;
            }else{
                return s.charAt(i)=='F'?1:0;
            }
        }
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        int ways=0;
        for(int k=i+1;k<=j-1;k=k+2){
            int lt=helper(i,k-1,s,dp,1);
            int lf=helper(i,k-1,s,dp,0);
            int rt=helper(k+1,j,s,dp,1);
            int rf=helper(k+1,j,s,dp,0);
            if(s.charAt(k)=='&'){
                if(isTrue==1) ways=ways+(lt*rt);
                else ways=ways+(lt*rf)+(lf*rt)+(lf*rf);
            }else if(s.charAt(k)=='|'){
                if(isTrue==1) ways=ways+(lt*rt)+(lt*rf)+(lf*rt);
                else ways=ways+(rf*lf);
            }else{
                if(isTrue==1) ways=ways+(rt*lf)+(rf*lt);
                else ways=ways+(rf*lf)+(rt*lt);
            }
        }
        return dp[i][j][isTrue]=ways;
    }
}
