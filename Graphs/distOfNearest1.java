class Node{
    int first,second,third;
    Node(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        ArrayList<ArrayList<Integer>> dist=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            dist.add(new ArrayList<>());
            for(int j=0;j<m;j++){
                dist.get(i).add(0);
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.add(new Node(i,j,0));
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!q.isEmpty()){
            int fir=q.peek().first;
            int sec=q.peek().second;
            int step=q.peek().third;
            q.remove();
            dist.get(fir).set(sec,step);
            for(int i=0;i<4;i++){
                int r=row[i]+fir;
                int c=col[i]+sec;
                if(r>=0&&r<n&&c>=0&&c<m&&vis[r][c]==0){
                    q.add(new Node(r,c,step+1));
                    vis[r][c]=1;
                }
            }
        }
        return dist;
    }
}
