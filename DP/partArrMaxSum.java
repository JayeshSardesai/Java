// Tabulation Method.
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        for(int i=n-1;i>=0;i--){
            int maxAns=Integer.MIN_VALUE;
            int len=0,max=Integer.MIN_VALUE;
            for(int j=i;j<Math.min(n,i+k);j++){
                len++;
                max=Math.max(max,arr[j]);
                int cost=(len*max)+dp[j+1];
                maxAns=Math.max(maxAns,cost);
            }
            dp[i]=maxAns;
        }
        return dp[0];
    }
}

// Memoisation Method.
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return  helper(0,arr,k,dp);
    }
    private int helper(int i,int[] arr,int k,int[] dp){
        if(i==arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int maxAns=Integer.MIN_VALUE;
        int len=0,max=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            int cost=(len*max)+helper(j+1,arr,k,dp);
            maxAns=Math.max(maxAns,cost);
        }
        return dp[i]=maxAns;
    }
}
