/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        Deque<Node> q=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        q.add(root);
        boolean ltr=false;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                if(ltr){
                    Node n=q.pollFirst();
                    if(n.left!=null) q.addLast(n.left);
                    if(n.right!=null) q.addLast(n.right);
                    res.add(n.data);
                }else{
                    Node n=q.pollLast();
                    if(n.right!=null) q.addFirst(n.right);
                    if(n.left!=null) q.addFirst(n.left);
                    res.add(n.data);
                }
            }
            ltr=!ltr;
        }
        return res;
    }
}
