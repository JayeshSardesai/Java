class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        int[] vis=new int[V];
        int[] path=new int[V];
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,path)==true) return true;
            }
        }
        return false;
    }
    public boolean dfs(int node,Map<Integer,ArrayList<Integer>> adj,int[] vis,int[] path){
        vis[node]=1;
        path[node]=1;
        for(Integer i:adj.get(node)){
            if(vis[i]==0){
                if(dfs(i,adj,vis,path)==true) return true;
            }else if(path[i]==1){
                return true;
            }
        }
        path[node]=0;
        return false;
    }
}
