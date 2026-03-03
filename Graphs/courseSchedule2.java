class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        int[] vis=new int[n];
        Stack<Integer> stk=new Stack<>();
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i,new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] path=new int[n];
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(dfs(i,adj,stk,vis,path)==false) return new ArrayList<>();
            }
        }
        int i=0;
        while(!stk.isEmpty()){
            res.add(stk.pop());
        }
        return res;
    }
    public boolean dfs(int node,Map<Integer,ArrayList<Integer>> adj,Stack<Integer> stk,int[] vis,int[] path){
        vis[node]=1;
        path[node]=1;
        for(Integer i:adj.get(node)){
            if(vis[i]==0){
                if(dfs(i,adj,stk,vis,path)==false) return false;
            }else if(path[i]==1) return false; 
        }
        path[node]=0;
        stk.push(node);
        return true;
    }
}
