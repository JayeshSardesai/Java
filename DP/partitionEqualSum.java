class Solution {
    private boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        if(arr[0]<=sum) dp[arr[0]]=true;
        for(int i=1;i<arr.length;i++){
            boolean[] temp=new boolean[sum+1];
            for(int j=0;j<=sum;j++){
                boolean notake=dp[j];
                boolean take=false;
                if(j>=arr[i])
                    take=dp[j-arr[i]];
                temp[j]=take||notake;
            }
            dp=temp;
        }
        return dp[sum];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int s=sum/2;
        if(isSubsetSum(nums,s)) return true;
        return false;
    }
}
