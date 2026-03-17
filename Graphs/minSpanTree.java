// Minimum Spanning Tree Using the Prim's Algorithm

class Pair{
    int node;
    int dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>>  adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<Pair>());
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.dis-b.dis);
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int[] vis=new int[V];
        q.add(new Pair(0,0));
        int sum=0;
        while(!q.isEmpty()){
            int nd=q.peek().node;
            int wt=q.peek().dis;
            q.remove();
            if(vis[nd]==1) continue;
            vis[nd]=1;
            sum+=wt;
            for(Pair p:adj.get(nd)){
                int adn=p.node;
                int w=p.dis;
                if(vis[adn]==0){
                    q.add(new Pair(adn,w));
                }
            }
        }
        return sum;
    }
}
