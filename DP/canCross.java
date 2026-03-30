class Solution {
    Map<Integer,Integer> map;
    int[][] dp;
    int n;
    boolean helper(int[] stones,int curr,int prev){
        if(curr==n-1) return true;
        if(dp[curr][prev]!=-1) return dp[curr][prev]==1?true:false;
        boolean res=false;
        for(int next=prev-1;next<=prev+1;next++){
            if(next>0){
                int n_stone=stones[curr]+next;
                if(map.containsKey(n_stone)){
                    res=res||helper(stones,map.get(n_stone),next);
                }
            }
        }
        dp[curr][prev]=res?1:0;
        return res;
    }
    public boolean canCross(int[] stones) {
        n=stones.length;
        map=new HashMap<>();
        dp=new int[n][n];
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
            Arrays.fill(dp[i],-1);
        } 
        return helper(stones,0,0);
    }
}
