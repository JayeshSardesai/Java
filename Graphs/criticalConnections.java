// Leetcode solution
class Solution {
    private int time=1;
    private void dfs(int node,int par,List<List<Integer>> adj,List<List<Integer>> bridge,int[] vis,int[] low,int[] tin){
        vis[node]=1;
        low[node]=tin[node]=time;
        time++;
        for(int it:adj.get(node)){
            if(it==par) continue;
            if(vis[it]==0){
                dfs(it,node,adj,bridge,vis,low,tin);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    bridge.add(Arrays.asList(it,node));
                }
            }else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] vis=new int[n];
        int[] low=new int[n];
        int[] tin=new int[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<connections.size();i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        List<List<Integer>> bridge=new ArrayList<>();
        dfs(0,-1,adj,bridge,vis,low,tin);
        return bridge;
    }
}


// GFG solution in this it has to be sorted edges.

// User function Template for Java

class Solution {
    private int time=1;
    private void dfs(int node,int par,ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> bridge,int[] vis,int[] low,int[] tin){
        vis[node]=1;
        low[node]=tin[node]=time;
        time++;
        for(int it:adj.get(node)){
            if(it==par) continue;
            if(vis[it]==0){
                dfs(it,node,adj,bridge,vis,low,tin);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    int u=Math.min(node,it);
                    int v=Math.max(node,it);
                    bridge.add(new ArrayList<>(Arrays.asList(u,v)));
                }
            }else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> criticalConnections(
        int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis=new int[v];
        int[] low=new int[v];
        int[] tin=new int[v];
        ArrayList<ArrayList<Integer>> bridge=new ArrayList<>();
        dfs(0,-1,adj,bridge,vis,low,tin);
        Collections.sort(bridge, (a, b) -> {
        if(a.get(0).equals(b.get(0))) return a.get(1) - b.get(1);
        return a.get(0) - b.get(0);
        });
        return bridge;
    }
}
