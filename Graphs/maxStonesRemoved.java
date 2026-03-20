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
    int maxRemove(int[][] stones) {
        // Code here
        int maxr=0;
        int maxc=0;
        for(int i=0;i<stones.length;i++){
            maxr=Math.max(maxr,stones[i][0]);
            maxc=Math.max(maxc,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(maxr+maxc+2);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            int nrow=stones[i][0];
            int ncol=stones[i][1]+maxr+1;
            ds.union(nrow,ncol);
            map.put(nrow,1);
            map.put(ncol,1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(ds.find(m.getKey())==m.getKey()){
                cnt++;
            }
        }
        return stones.length-cnt;
    }
};
