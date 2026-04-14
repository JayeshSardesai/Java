class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int n=arr.length;
        int total=0;
        for(int i=0;i<arr.length;i++) total+=arr[i];
        if((total-diff)<0||(total-diff)%2!=0) return 0;
        int target=(total-diff)/2;
        int[] dp=new int[target+1];
        if(arr[0]==0) dp[0]=2;
        else{
            dp[0]=1;
            if(arr[0]<=target) dp[arr[0]]=1;
        }
        for(int i=1;i<n;i++){
            int[] temp=new int[target+1];
            for(int j=0;j<=target;j++){
                int nonPick=dp[j];
                int pick=0;
                if(arr[i]<=j) pick=dp[j-arr[i]];
                temp[j]=pick+nonPick;
            }
            dp=temp;
        }
        return dp[target];
    }
}
