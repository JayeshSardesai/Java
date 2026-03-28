// Using the DP memoisation.
class Solution {
    public int nthFibonacci(int n) {
        // code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fib(n,dp);
    }
    private int fib(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fib(n-1,dp)+fib(n-2,dp);
    }
}

// Using the tabulation but optimised one for that 
class Solution {
    public int nthFibonacci(int n) {
        // code here
        if(n==0) return 0;
        int fir=0,sec=1;
        int th=fir+sec;
        for(int i=3;i<=n;i++){
            fir=sec;
            sec=th;
            th=fir+sec;
        }
        return th;
    }
}
