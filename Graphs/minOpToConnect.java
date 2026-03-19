class DisjointSet{
    int[] par;
    int[] rank;
    DisjointSet(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }
    int find(int node){
        if(par[node]==node) return node;
        return par[node]=find(par[node]);
    }
    void union(int u,int v){
        int paru=find(u);
        int parv=find(v);
        if(paru==parv) return;
        if(rank[paru]<rank[parv]){
            par[paru]=parv;
        }else if(rank[parv]<rank[paru]){
            par[parv]=paru;
        }else{
            par[parv]=paru;
            rank[paru]++;
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int extra=0;
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.find(u)==ds.find(v)){
                extra++;
            }else{
                ds.union(u,v);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(ds.find(i)==i) cnt++;
        }
        if(extra>=cnt-1) return cnt-1;
        return -1;
    }
}
