class DisjointSet{
    int[] par;
    int[] size;
    DisjointSet(int n) {
        par = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
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
        if(size[paru]<size[parv]){
            par[paru]=parv;
            size[parv]+=size[paru];
        }else{
            par[parv]=paru;
            size[paru]+=size[parv];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        int[] r={-1,0,1,0};
        int[] c={0,1,0,-1};
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                for(int i=0;i<4;i++){
                    int nr=row+r[i];
                    int nc=col+c[i];
                    if(nr<n&&nc<n&&nr>=0&&nc>=0&&grid[nr][nc]==1){
                        ds.union(row*n+col,nr*n+nc);
                    }
                }
            }
        }
        int mx=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1) continue;
                HashSet<Integer> com=new HashSet<>();
                for(int i=0;i<4;i++){
                    int nr=row+r[i];
                    int nc=col+c[i];
                    if(nr<n&&nc<n&&nr>=0&&nc>=0&&grid[nr][nc]==1){
                        com.add(ds.find(nr*n+nc));
                    }
                }
                int total=0;
                for(int it:com){
                    total+=ds.size[it];
                }
                mx=Math.max(total+1,mx);
            }
        }
        for(int cel=0;cel<n*n;cel++)
            mx=Math.max(mx,ds.size[ds.find(cel)]);
        return mx;
    }
}
