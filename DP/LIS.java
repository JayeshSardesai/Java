// Space Optimized Tabulation Method.
class Solution {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int[] temp=new int[n+1];
            for(int j=i-1;j>=-1;j--){
                int len=dp[j+1];
                if(j==-1||arr[i]>arr[j]){
                    len=Math.max(len,1+dp[i+1]);
                }
                temp[j+1]=len;
            }
            dp=temp;
        }
        return dp[0];
    }
}

// Tabulation Method.
class Solution {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int len=dp[i+1][j+1];
                if(j==-1||arr[i]>arr[j]){
                    len=Math.max(len,1+dp[i+1][i+1]);
                }
                dp[i][j+1]=len;
            }
        }
        return dp[0][0];
    }
}

// Memoisation Method.
class Solution {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return helper(0,-1,arr,dp);
    }
    static int helper(int i,int prev,int[] arr,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int len=helper(i+1,prev,arr,dp);
        if(prev==-1||arr[i]>arr[prev]){
            len=Math.max(len,1+helper(i+1,i,arr,dp));
        }
        return dp[i][prev+1]=len;
    }
}
