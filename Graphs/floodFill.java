class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        int n=image.length;
        int m=image[0].length;
        int originalcolor=image[sr][sc];
        if(originalcolor==newColor) return image;
        image[sr][sc]=newColor;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.remove();
            int[] row={-1,0,1,0};
            int[] col={0,1,0,-1};
            for(int i=0;i<4;i++){
                int newr=r+row[i];
                int newc=c+col[i];
                if(newr>=0&&newr<n&&newc>=0&&newc<m&&image[newr][newc]==originalcolor){
                    q.add(new Pair(newr,newc));
                    image[newr][newc]=newColor;
                }
            }
        }
        return image;
    }
}
