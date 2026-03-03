class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int[] vis=new int[V];
        Stack<Integer> stk=new Stack<>();
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++) adj.put(i,new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,stk,vis);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!stk.isEmpty()){
            res.add(stk.pop());
        }
        return res;
    }
    public void dfs(int node,Map<Integer,ArrayList<Integer>> adj,Stack<Integer> stk,int[] vis){
        vis[node]=1;
        for(Integer i:adj.get(node)){
            if(vis[i]==0) dfs(i,adj,stk,vis);
        }
        stk.push(node);
    }
}
