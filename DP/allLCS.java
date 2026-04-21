// User function Template for Java

class Solution {
    public List<String> allLCS(String s1, String s2) {
        // Code here
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=m;i++) dp[0][i]=0;
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        Set<String> s=new HashSet<>();
        helper(n,m,s1,s2,dp,s,"");
        List<String> ans=new ArrayList<>(s);
        Collections.sort(ans);
        return ans;
    }
    void helper(int i,int j,String s1,String s2,int[][] dp,Set<String> s,String cur){
        if(i==0||j==0){
            s.add(cur);
            return;
        }
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            helper(i-1,j-1,s1,s2,dp,s,s1.charAt(i-1)+cur);
        }else{
            if(dp[i-1][j]==dp[i][j]){
                helper(i-1,j,s1,s2,dp,s,cur);
            }
            if(dp[i][j-1]==dp[i][j]){
                helper(i,j-1,s1,s2,dp,s,cur);
            }
        } 
    }
}
