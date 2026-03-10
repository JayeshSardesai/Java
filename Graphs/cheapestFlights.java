class Pair{
    int fir,sec;
    Pair(int fir,int sec){
        this.fir=fir;
        this.sec=sec;
    }
}
class tuple{
    int fir,sec,thr;
    tuple(int fir,int sec,int thr){
        this.fir=fir;
        this.sec=sec;
        this.thr=thr;
    }
}
class Solution {
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<tuple> q=new LinkedList<>();
        int[] dist=new int[n];
        for(int i=0;i<n;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        q.add(new tuple(0,src,0));
        while(!q.isEmpty()){
            tuple t=q.peek();
            int steps=t.fir;
            int node=t.sec;
            int cost=t.thr;
            q.remove();
            for(Pair it:adj.get(node)){
                int nd=it.fir;
                int cst=it.sec;
                if(cost+cst<dist[nd]&&steps<=k){
                    dist[nd]=cost+cst;
                    q.add(new tuple(steps+1,nd,dist[nd]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
