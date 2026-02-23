class Solution {
    Map<Integer,Boolean> vis=new HashMap<>();
    public boolean isCycle(int V, int[][] edges) {
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<V;i++){
            if(!vis.getOrDefault(i,false)){
                if(dfs(adj,i,-1)==true) return true;
            }
        }
        return false;
    }
    public boolean dfs(Map<Integer,ArrayList<Integer>> adj,int node,int parent){
        vis.put(node,true);
        for(Integer i:adj.get(node)){
            if(!vis.getOrDefault(i,false)){
                if(dfs(adj,i,node)==true) return true;
            }else if(i!=parent){
                return true;
            }
        }
        return false;
    }
}
