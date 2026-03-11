class Pair{
    int fir,sec;
    Pair(int fir,int sec){
        this.fir=fir;
        this.sec=sec;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.sec-b.sec);
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<Pair>());
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int[] dist=new int[n+1];
        for(int i=1;i<=n;i++) dist[i]=Integer.MAX_VALUE;
        dist[k]=0;
        q.add(new Pair(k,0));
        while(!q.isEmpty()){
            Pair p=q.peek();
            int node=p.fir;
            int time=p.sec;
            q.remove();
            for(Pair t:adj.get(node)){
                int adjn=t.fir;
                int tm=t.sec;
                if(time+tm<dist[adjn]){
                    dist[adjn]=time+tm;
                    q.add(new Pair(adjn,time+tm));
                }
            }
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            if(ans<dist[i]) ans=dist[i];
        }
        return ans;
    }
}
