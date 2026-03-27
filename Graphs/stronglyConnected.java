class Solution {
    void dfs(int node,List<List<Integer>> adj,int[] vis,Stack<Integer> stk){
        vis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                dfs(i,adj,vis,stk);
            }
        }
        stk.push(node);
    }
    void dfs3(int node,List<List<Integer>> trans,int[] vis){
        vis[node]=1;
        for(int i:trans.get(node)){
            if(vis[i]==0){
                dfs3(i,trans,vis);
            }
        }
    }
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] vis=new int[V];
        Stack<Integer>stk=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,stk);
            }
        }
        List<List<Integer>> trans=new ArrayList<>();
        for(int i=0;i<V;i++) trans.add(new ArrayList<>());
        Arrays.fill(vis,0);
        for(int i=0;i<edges.length;i++){
            trans.get(edges[i][1]).add(edges[i][0]);
        }
        int ans=0;
        while(!stk.isEmpty()){
            int i=stk.pop();
            if(vis[i]==0){
                ans++;
                dfs3(i,trans,vis);
            }
        }
        return ans;
    }
}
