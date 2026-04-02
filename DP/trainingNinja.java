class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        int day=mat.length;
        int[][] dp=new int[day][4];
        for(int i=0;i<day;i++) Arrays.fill(dp[i],-1);
        return helper(day-1,3,mat,dp);
    }
    private int helper(int day,int last,int[][] mat,int[][] dp){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last)
                    maxi=Math.max(maxi,mat[day][i]);
            }
            return maxi;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        int maxi=0;
        int temp=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                temp=mat[day][i]+helper(day-1,i,mat,dp);
                maxi=Math.max(maxi,temp);
            }
        }
        return dp[day][last]=maxi;
    }
}
