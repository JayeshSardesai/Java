class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return tribo (n,dp);
    }
    private int tribo (int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        if (n == 0 || n == 1) {
            return dp[n] = n;
        }
        if (n == 2) return dp[n] = 1;
        return dp[n] = tribo (n - 3,dp) + 
                       tribo (n - 2,dp) + 
                       tribo (n - 1,dp);
    }
}
