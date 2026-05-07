class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n=arr.length;
        int[] dp=new int[n+1];
        int[] hash=new int[n+1];
        Arrays.fill(dp,1);
        int max=1;
        int last=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&dp[i]<1+dp[j]){
                    hash[i]=j;
                    dp[i]=1+dp[j];
                }
            }
            if(max<dp[i]){
                max=dp[i];
                last=i;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(arr[last]);
        while(hash[last]!=last){
            last=hash[last];
            ans.add(arr[last]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
