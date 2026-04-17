// Optimized Space Tabulation Method. 
class Solution {
    public int findTargetSumWays(int[] nums, int tar) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<nums.length;i++) total+=nums[i];
        if((total-tar)<0||(total-tar)%2!=0) return 0;
        int target=(total-tar)/2;
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

// Memoisation Method.
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if ((totalSum + target) % 2 != 0) return 0;
        if (totalSum < Math.abs(target)) return 0;

        int s1 = (totalSum + target) / 2;
        int[][] dp=new int[nums.length][s1+1];
        return helper(nums.length-1,s1,dp,nums);
    }
    int helper(int i,int sum,int[][] dp,int[] arr){
        if(i==0){
            if(sum==0&&arr[0]==0) return 2;
            if(sum==0||sum==arr[0]) return 1;
            return 0;
        }
        if(dp[i][sum]!=0) return dp[i][sum];
        int notake=helper(i-1,sum,dp,arr);
        int take=0;
        if(sum>=arr[i])
            take=helper(i-1,sum-arr[i],dp,arr);
        return dp[i][sum]=take+notake;
    }
}
