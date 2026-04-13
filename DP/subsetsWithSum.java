// Optimized Tabulation Method.
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[] dp=new int[target+1];
        if(nums[0]==0) dp[0]=2;
        else{
            dp[0]=1;
            if(nums[0]<=target) dp[nums[0]]=1;
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[target+1];
            for(int j=0;j<=target;j++){
                int nonPick=dp[j];
                int pick=0;
                if(nums[i]<=j) pick=dp[j-nums[i]];
                temp[j]=pick+nonPick;
            }
            dp=temp;
        }
        return dp[target];
    }
}

// Tabulation Method.
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        if(nums[0]==0) dp[0][0]=2;
        else{
            dp[0][0]=1;
            if(nums[0]<=target) dp[0][nums[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int nonPick=dp[i-1][j];
                int pick=0;
                if(nums[i]<=j) pick=dp[i-1][j-nums[i]];
                dp[i][j]=pick+nonPick;
            }
        }
        return dp[n-1][target];
    }
}

// Memoisation Method.
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(n-1,target,nums,dp);
    }
    private int helper(int i,int target,int[] nums,int[][] dp){
        if(i==0){
            if(target==0&&nums[i]==0) return 2;
            if(target==0||nums[i]==target) return 1;
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int nonPick=helper(i-1,target,nums,dp);
        int pick=0;
        if(nums[i]<=target){
            pick=helper(i-1,target-nums[i],nums,dp);
        }
        return dp[i][target]=pick+nonPick;
    }
}
