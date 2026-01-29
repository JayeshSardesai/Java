/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Pair{
    int line;
    Node node;
    Pair(Node node,int line){
        this.node=node;
        this.line=line;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair t=q.poll();
            int line=t.line;
            Node temp=t.node;
            map.put(line,temp.data);
            if(temp.left!=null) q.offer(new Pair(temp.left,line-1));
            if(temp.right!=null) q.offer(new Pair(temp.right,line+1));
        }
        for(Map.Entry<Integer,Integer> t:map.entrySet()){
            res.add(t.getValue());
        }
        return res;
    }
}
