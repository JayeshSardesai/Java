// User function Template for Java
class Pair{
    int fir,sec;
    Pair(int fir,int sec){
        this.fir=fir;
        this.sec=sec;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,0));
        int[] dist=new int[100000];
        for(int i=0;i<100000;i++) dist[i]=Integer.MAX_VALUE;
        dist[0]=0;
        while(!q.isEmpty()){
            int node=q.peek().fir;
            int steps=q.peek().sec;
            q.remove();
            if(node==end) return steps;
            for(int i:arr){
                int nd=(i*node)%100000;
                if(steps+1<dist[nd]){
                    dist[nd]=steps+1;
                    q.add(new Pair(nd,steps+1));
                }
            }
        }
        return -1;
    }
}
