// This problem well solved using the greedy method as it takes student.length*cookies.length time complexity with dp 
//and using greedy it takes only max(student.length,cookies.length) this is only for knowledge purpose.
// Optimized tabulation method.
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int[] dp=new int[s.length+1];
        for(int i=g.length-1;i>=0;i--){
            int[] temp=new int[s.length+1];
            for(int j=s.length-1;j>=0;j--){
                int skip=temp[j+1];
                int noSkip=0;
                if(s[j]>=g[i]) noSkip=1+dp[j+1];
                temp[j]=Math.max(skip,noSkip);
            }
            dp=temp;
        }
        return dp[0];
    }
}

// Tabulation method.
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int[][] dp=new int[g.length+1][s.length+1];
        for(int i=g.length-1;i>=0;i--){
            for(int j=s.length;j>=0;j--){
                int skip=dp[i][j+1];
                int noSkip=0;
                if(s[j]>=g[i]) noSkip=dp[i+1][j+1];
                dp[i][j]=Math.max(skip,noSkip);
            }
        }
        return dp[0][0];
    }
    
}

// Memoisation method.
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int[][] dp=new int[g.length][s.length];
        for(int i=0;i<g.length;i++) Arrays.fill(dp[i],-1);
        return helper(0,0,g,s,dp);
    }
    private int helper(int stud,int cook,int[] g,int[] s,int[][] dp){
        if(stud>=g.length||cook>=s.length) return 0;
        if(dp[stud][cook]!=-1) return dp[stud][cook];
        int res=0;
        if(s[cook]>=g[stud]) res=Math.max(res,1+helper(stud+1,cook+1,g,s,dp));
        res=Math.max(res,helper(stud,cook+1,g,s,dp));
        return dp[stud][cook]=res;
    }
}
