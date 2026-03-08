class Pair{
    int fir,sec;
    Pair(int fir,int sec){
        this.fir=fir;
        this.sec=sec;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int[] dist=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.sec-b.sec);
        q.add(new Pair(src,0));
        while(!q.isEmpty()){
            int node=q.peek().fir;
            int dis=q.peek().sec;
            q.remove();
            if(dis>dist[node]) continue;
            for(Pair p:adj.get(node)){
                int nd=p.fir;
                int d=p.sec;
                if(dist[node]+d<dist[nd]){
                    dist[nd]=dist[node]+d;
                    q.add(new Pair(nd,dist[nd]));
                }
            }
        }
        return dist;
    }
}
