// Adjacency list is given.
class Solution {
    private boolean dfs(int node,int c,int[] color,int[][] graph){
        color[node]=c;
        for(Integer i:graph[node]){
            if(color[i]==-1){
                if(dfs(i,1-c,color,graph)==false) return false;
            }else if(color[i]==c) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int[] color=new int[v];
        for(int i=0;i<v;i++) color[i]=-1;
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false) return false;
            }
        }
        return true;
    }
}

// Adjacency list is created.
class Solution {
    private boolean dfs(int node,int c,int[] color,ArrayList<ArrayList<Integer>> adj){
        color[node]=c;
        for(Integer i:adj.get(node)){
            if(color[i]==-1){
                if(dfs(i,1-c,color,adj)==false) return false;
            }else if(color[i]==c) return false;
        }
        return true;
    }
    public boolean isBipartite(int v, int[][] edges) {
        // Code here
        int[] color=new int[v];
        for(int i=0;i<v;i++) color[i]=-1;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false) return false;
            }
        }
        return true;
    }
}
