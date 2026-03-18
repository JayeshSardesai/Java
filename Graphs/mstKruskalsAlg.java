// User function Template for Java
class tuple{
    int u,v,wt;
    tuple(int u,int v,int wt){
        this.u=u;
        this.v=v;
        this.wt=wt;
    }
}
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        PriorityQueue<tuple> q=new PriorityQueue<>((a,b)->a.wt-b.wt);
        for(int i=0;i<edges.length;i++){
            q.add(new tuple(edges[i][0],edges[i][1],edges[i][2]));
        }
        DisjointSet ds=new DisjointSet(V);
        int wgt=0;
        while(!q.isEmpty()){
            int u=q.peek().u;
            int v=q.peek().v;
            int wt=q.peek().wt;
            q.remove();
            if(ds.find(u)!=ds.find(v)){
                wgt+=wt;
                ds.union(u,v);
            }
        }
        return wgt;
    }
}
class DisjointSet {
    private int[] parent;
    private int[] rank;
    public DisjointSet(int v) {
        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
    }
    public int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]); 
    }
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
                rank[rootJ]++;
            }
        }
    }
}
