// Optimized tabulation method.
class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
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
}

// Tabulation method.
class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean[][] dp=new boolean[arr.length][sum+1];
        for(int i=0;i<arr.length;i++) dp[i][0]=true;
        if(arr[0]<=sum) dp[0][arr[0]]=true;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=sum;j++){
                boolean notake=dp[i-1][j];
                boolean take=false;
                if(j>=arr[i])
                    take=dp[i-1][j-arr[i]];
                dp[i][j]=take||notake;
            }
        }
        return dp[arr.length-1][sum];
    }
}

// Memoisation method.
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
