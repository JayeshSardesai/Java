// Tabulation Method.
class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        for(int i=n-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                if(isPali(i,j,s)){
                    int cost=1+dp[j+1];
                    min=Math.min(min,cost);
                }
            }
            dp[i]=min;
        }
        return dp[0]-1;
    }
    private boolean isPali(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}

// Memoisation Method.
class Solution {
    public int minCut(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0,s,dp)-1;
    }
    private int helper(int i,String s,int[] dp){
        if(i==s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPali(i,j,s)){
                int cost=1+helper(j+1,s,dp);
                min=Math.min(min,cost);
            }
        }
        return dp[i]=min;
    }
    private boolean isPali(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
