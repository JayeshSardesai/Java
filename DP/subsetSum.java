class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean[][] dp=new Boolean[arr.length][sum+1];
        return helper(arr.length-1,sum,dp,arr);
    }
    static Boolean helper(int i,int sum,Boolean[][] dp,int[] arr){
        if(sum==0) return true;
        if(i==0) return (sum==arr[i]);
        if(dp[i][sum]!=null) return dp[i][sum];
        Boolean notake=helper(i-1,sum,dp,arr);
        Boolean take=false;
        if(sum>=arr[i])
            take=helper(i-1,sum-arr[i],dp,arr);
        return dp[i][sum]=take||notake;
    }
}
