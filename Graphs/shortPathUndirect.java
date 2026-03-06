class Pair{
    int first,sec;
    Pair(int first,int sec){
        this.first=first;
        this.sec=sec;
    }
}
class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        int[] dist=new int[V];
        dist[src]=0;
        for(int i=0;i<V;i++) dist[i]=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int node=q.peek().first;
            int d=q.peek().sec;
            q.remove();
            if(dist[node]>d) dist[node]=d;
            for(int i:adj.get(node)){
                if(dist[i]==Integer.MAX_VALUE) q.add(new Pair(i,d+1));
            }
        }
        for(int i=0;i<V;i++) if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        return dist;
    }
}
