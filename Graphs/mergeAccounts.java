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
    public ArrayList<ArrayList<String>> accMerge(String[][] arr) {
        // code here
        int n=arr.length;
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<arr[i].length;j++){
                String mail=arr[i][j];
                if(map.containsKey(mail)==false){
                    map.put(mail,i);
                }else{
                    ds.union(i,map.get(mail));
                }
            }
        }
        ArrayList<ArrayList<String>> mergeMail=new ArrayList<>();
        for(int i=0;i<n;i++){
            mergeMail.add(new ArrayList<String>());
        }
        for(Map.Entry<String,Integer> it:map.entrySet()){
            String mail=it.getKey();
            int node=ds.find(map.get(mail));
            mergeMail.get(node).add(mail);
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        for(int i=0;i<mergeMail.size();i++){
            if(mergeMail.get(i).size()==0) continue;
            Collections.sort(mergeMail.get(i));
            ArrayList<String> temp=new ArrayList<>();
            temp.add(arr[i][0]);
            for(String it:mergeMail.get(i)){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
