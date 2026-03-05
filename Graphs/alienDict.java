class Solution {
    public List<Integer> topoSort(int v,List<List<Integer>> adj){
        int[] ind=new int[v];
        for(int i=0;i<v;i++){
            for(int j:adj.get(i)){
                ind[j]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(ind[i]==0) q.add(i);
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            topo.add(node);
            for(int i:adj.get(node)){
                ind[i]--;
                if(ind[i]==0) q.add(i);
            }
        }
        return topo;
    }
    public String findOrder(String[] words) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        int v=26;
        for(int i=0;i<26;i++) adj.add(new ArrayList<>());
        boolean[] present=new boolean[26];
        int cnt=0;
        for(String w:words){
            for(char c:w.toCharArray()){
                if(!present[c-'a']){
                    present[c-'a']=true;
                    cnt++;
                }
            }
        }
        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            if(s1.length()>s2.length()&&s1.startsWith(s2)) return "";
            int l=Math.min(s1.length(),s2.length());
            for(int j=0;j<l;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> topo=topoSort(v,adj);
        StringBuilder str=new StringBuilder();
        for(int i:topo){
            if(present[i]) str.append((char)(i+'a'));
        }
        if(str.length()!=cnt) return "";
        return str.toString();
    }
}
