// User function Template for Java

class Solution {
    static Map<Integer,Boolean> vis;
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> ad=new ArrayList<>();
        vis=new HashMap<>();
        for(int i=0;i<V;i++){
            ad.add(new ArrayList<>());
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1&&i!=j){
                    ad.get(i).add(j);
                }
            }
        }
        int res=0;
        for(int i=0;i<V;i++){
            if(!vis.getOrDefault(i,false)){
                dfs(ad,i);
                res++;
            }
        }
        return res;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int i){
        vis.put(i,true);
        for(Integer temp:adj.get(i)){
            if(!vis.getOrDefault(temp,false)){
                dfs(adj,temp);
            }
        }
    }
}
