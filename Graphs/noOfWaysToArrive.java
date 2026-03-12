class Pair{
    int fir;
    long sec;
    Pair(int fir,long sec){
        this.fir=fir;
        this.sec=sec;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Long.compare(a.sec,b.sec));
        for(int i=0;i<n;i++) adj.add(new ArrayList<Pair>());
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long[] dist=new long[n];
        int[] ways=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        dist[0]=0;
        ways[0]=1;
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair p=q.peek();
            int node=p.fir;
            long dis=p.sec;
            q.remove();
            if(dis>dist[node]) continue;
            for(Pair t:adj.get(node)){
                int nd=t.fir;
                long dt=t.sec;
                if(dis+dt<dist[nd]){
                    dist[nd]=dis+dt;
                    q.add(new Pair(nd,dist[nd]));
                    ways[nd]=ways[node];
                }else if(dis+dt==dist[nd]){
                    ways[nd]=(ways[nd]+ways[node])%(int)(1e9+7);
                }
            }
        }
        return ways[n-1]%(int)(1e9+7);
    }
}
