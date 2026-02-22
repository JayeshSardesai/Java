class Pair{
    int first,sec;
    Pair(int first,int sec){
        this.first=first;
        this.sec=sec;
    }
}
class Solution {
    public boolean detect(Map<Integer,ArrayList<Integer>> adj,Map<Integer,Boolean> vis,int src){
        Queue<Pair> q=new LinkedList<>();
        vis.put(src,true);
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().sec;
            q.remove();
            for(int val:adj.get(node)){
                if(!vis.getOrDefault(val,false)){
                    vis.put(val,true);
                    q.add(new Pair(val,node));
                }else if(parent!=val) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Map<Integer,Boolean> vis=new HashMap<>();
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++) adj.put(i,new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<V;i++){
            if(!vis.getOrDefault(i,false)){
                if(detect(adj,vis,i)==true) return true;
            }
        }
        return false;
    }
}
