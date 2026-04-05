// Djekstra method.
class tuple{
    int r,c,v;
    tuple(int r,int c,int v){
        this.r=r;
        this.c=c;
        this.v=v;
    }
}
class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    public int minimumCostPath(int[][] grid) {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<tuple> q=new PriorityQueue<>((a,b)->a.v-b.v);
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        q.add(new tuple(0,0,grid[0][0]));
        dist[0][0]=grid[0][0];
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            int v=q.peek().v;
            q.poll();
            if(v>dist[r][c]) continue;
            if(r==m-1&&c==n-1) return v;
            for(int i=0;i<4;i++){
                int ro=r+row[i];
                int co=c+col[i];
                if(ro>=0&&co>=0&&ro<m&&co<n){
                    int nc=v+grid[ro][co];
                    if(nc<dist[ro][co]){
                        dist[ro][co]=nc;
                        q.add(new tuple(ro,co,nc));
                    }
                }
            }
        }
        return -1;
    }
}
