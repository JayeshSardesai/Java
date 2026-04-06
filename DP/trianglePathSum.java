// Optimized Tabulation Method.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=triangle.get(n-1).get(i);
        for(int i=n-2;i>=0;i--){
            int[] temp=new int[i+1];
            for(int j=i;j>=0;j--){
                int down=dp[j];
                int diag=dp[j+1];
                temp[j]=triangle.get(i).get(j)+Math.min(down,diag);
            }
            dp=temp;
        }
        return dp[0];
    }
}

// Tabulation Method.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[n-1][i]=triangle.get(n-1).get(i);
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down=dp[i+1][j];
                int diag=dp[i+1][j+1];
                dp[i][j]=triangle.get(i).get(j)+Math.min(down,diag);
            }
        }
        return dp[0][0];
    }
}

// Memoisation Method.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        return helper(0,0,dp,triangle);
    }
    private int helper(int m,int n,int[][] dp,List<List<Integer>> triangle){
        if(m==triangle.size()-1) return triangle.get(m).get(n);
        if(dp[m][n]!=Integer.MAX_VALUE) return dp[m][n];
        int down=helper(m+1,n,dp,triangle);
        int diag=helper(m+1,n+1,dp,triangle);
        int ans=Math.min(down,diag);
        if(ans==Integer.MAX_VALUE) dp[m][n]=ans;
        return dp[m][n]=triangle.get(m).get(n)+ans;
    }
}
