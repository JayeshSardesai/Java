class Solution {
    ArrayList<ArrayList<Integer>> res;
    Map<Integer,Boolean> vis=new HashMap<>();
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        res=new ArrayList<>();
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(!adj.containsKey(edges[i][0])) adj.put(edges[i][0],new ArrayList<>());
            adj.get(edges[i][0]).add(edges[i][1]);
            if(!adj.containsKey(edges[i][1])) adj.put(edges[i][1],new ArrayList<>());
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<V;i++){
            if(!vis.getOrDefault(i,false)){
                ArrayList<Integer> temp=new ArrayList<>();
                helper(adj,temp,i);
                res.add(temp);
            }
        }
        return res;
    }
    void helper(Map<Integer,ArrayList<Integer>> adj,ArrayList<Integer> temp,int i){
        temp.add(i);
        vis.put(i,true);
        if(!adj.containsKey(i)) return;
        for(Integer t:adj.get(i)){
            if(!vis.getOrDefault(t,false)) helper(adj,temp,t);
        }
    }
}
