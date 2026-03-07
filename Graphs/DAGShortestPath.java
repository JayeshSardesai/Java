// User function Template for Java
class Pair{
    int fir,sec;
    Pair(int fir,int sec){
        this.fir=fir;
        this.sec=sec;
    }
}
class Solution {
    public void topoSort(int node,ArrayList<ArrayList<Pair>> adj,int[] vis,Stack<Integer> s){
        vis[node]=1;
        for(Pair t:adj.get(node)){
            if(vis[t.fir]==0){
                topoSort(t.fir,adj,vis,s);
            }
        }
        s.add(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<V;i++){
            ArrayList<Pair> t=new ArrayList<>();
            adj.add(t);
        }
        for(int i=0;i<E;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                topoSort(i,adj,vis,s);
            }
        }
        int[] dist=new int[V];
        for(int i=0;i<V;i++) dist[i]=Integer.MAX_VALUE;
        dist[0]=0;
        while(!s.isEmpty()){
            int node=s.pop();
            for(Pair p:adj.get(node)){
                if(dist[node]!=Integer.MAX_VALUE&&dist[node]+p.sec<dist[p.fir]){
                    dist[p.fir]=dist[node]+p.sec;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        }
        return dist;
    }
}
