// Tabulation optimized approach.
class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int prev=0,prev2=0;
        for(int i=1;i<height.length;i++){
            int l=prev+Math.abs(height[i]-height[i-1]);
            int r=Integer.MAX_VALUE;
            if(i>1)
                r=prev2+Math.abs(height[i]-height[i-2]);
            int curr=Math.min(l,r);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}

// Recursive way memoisation.
class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,dp,height);
    }
    private int helper(int n,int[] dp,int[] height){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int l=helper(n-1,dp,height)+Math.abs(height[n]-height[n-1]);
        int r=Integer.MAX_VALUE;
        if(n>1)
            r=helper(n-2,dp,height)+Math.abs(height[n]-height[n-2]);
        return dp[n]=Math.min(l,r);
    }
}
