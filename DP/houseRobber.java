// Ooptimized approach with the tabulation concept memory space optimisation.
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev=nums[0],prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1) pick=pick+prev2;
            int nop=prev;
            int curr=Math.max(nop,pick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}


// Memoisation based approach.
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,nums,dp);
    }
    private int helper(int ind,int[] nums,int[] dp){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick=nums[ind]+helper(ind-2,nums,dp);
        int nop=helper(ind-1,nums,dp);
        return dp[ind]=Math.max(pick,nop);
    }
}
