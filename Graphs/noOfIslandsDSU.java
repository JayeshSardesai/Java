// User function Template for Java
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
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        DisjointSet ds=new DisjointSet(rows*cols);
        int cnt=0;
        int[][] vis=new int[rows][cols];
        List<Integer> ans=new ArrayList<>();
        int[] r={-1,0,1,0};
        int[] c={0,1,0,-1};
        for(int i=0;i<operators.length;i++){
            int row=operators[i][0];
            int col=operators[i][1];
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            vis[row][col]=1;
            cnt++;
            for(int j=0;j<4;j++){
                int nr=row+r[j];
                int nc=col+c[j];
                if(nr<rows&&nc<cols&&nr>=0&&nc>=0){
                    if(vis[nr][nc]==1){
                        if(ds.find((nr*cols)+nc)!=ds.find((row*cols)+col)){
                            cnt--;
                            ds.union(((nr*cols)+nc),((row*cols)+col));
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
