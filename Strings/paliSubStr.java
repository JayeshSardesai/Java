// This is the code for all substring irrespective of length.
class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int cnt=0;
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(i,j,s,dp)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private boolean check(int i,int j,String s,int[][] dp){
        if(i>=j){
            return true;
        } 
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        if(s.charAt(i)==s.charAt(j)&&check(i+1,j-1,s,dp)){
            dp[i][j]=1;
            return true;
        }
        dp[i][j]=0;
        return false;
    }
}

// This code is for the substring having length greater than 1.
class Solution {
    public int countPS(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                cnt++;
            }
        }
        for(int len = 3; len <= n; len++) {
            for(int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
