/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Pair{
    int col;
    Node node;
    Pair(Node node,int col){
        this.node=node;
        this.col=col;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int col=temp.col;
            Node t=temp.node;
            map.putIfAbsent(col,t.data);
            if(t.left!=null){
                q.offer(new Pair(t.left,col-1));
            }
            if(t.right!=null){
                q.offer(new Pair(t.right,col+1));
            }
        }
        for(Map.Entry<Integer,Integer> t:map.entrySet()){
            res.add(t.getValue());
        }
        return res;
    }
}
