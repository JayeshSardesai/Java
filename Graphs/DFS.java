class Solution {
    ArrayList<Integer> res;
    Map<Integer,Boolean> vis;
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        res=new ArrayList<>();
        vis=new HashMap<>();
        helper(adj,0);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> adj,int j){
        res.add(j);
        vis.put(j,true);
        for(Integer it:adj.get(i)){
            if(!vis.getOrDefault(it,false)){
                helper(adj,it);
            }
        }
    }
}
