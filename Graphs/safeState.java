// Using the topological sort technique and reversing the edges I have solved this problem

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> rev=new ArrayList<>();
        int v=graph.length;
        int[] ind=new int[v];
        for(int i=0;i<v;i++) rev.add(new ArrayList<>());
        for(int i=0;i<v;i++){
            for(Integer it:graph[i]){
                rev.get(it).add(i);
                ind[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(ind[i]==0) q.add(i);
        }
        List<Integer> safe=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            safe.add(node);
            for(Integer i:rev.get(node)){
                ind[i]--;
                if(ind[i]==0) q.add(i);
            }
        }
        Collections.sort(safe);
        return safe;
    }
}
