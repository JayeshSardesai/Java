/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // ArrayList<Integer> res;
    public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res=new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                res.add(curr.data);
                curr=curr.right;
            }else{
                Node t=curr.left;
                while(t.right!=null&&t.right!=curr){
                    t=t.right;
                }
                if(t.right==null){
                    t.right=curr;
                    curr=curr.left;
                }else{
                    res.add(curr.data);
                    t.right=null;
                    curr=curr.right;
                }
            }
        }
        return res;
    }
}
