class Solution {
    public int minDifference(int arr[]) {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++) sum+=arr[i];
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
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[i]==true){
                int s1=i;
                int s2=sum-s1;
                min=Math.min(min,Math.abs(s2-s1));
            }
        }
        return min;
    }
}
