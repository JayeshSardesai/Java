class Pair{
    int fir,sec;
    Pair(int fir,int sec){
        this.fir=fir;
        this.sec=sec;
    }
}
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int[] dist=new int[n+1];
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
            parent[i]=i;
        }
        dist[1]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.sec-b.sec);
        q.add(new Pair(1,0));
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
                    parent[nd]=node;
                }
            }
        }
        List<Integer> path=new ArrayList<>();
        if(dist[n]==Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node=n;
        while(parent[node]!=node){
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        path.add(dist[n]);
        Collections.reverse(path);
        return path;
    }
}
