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

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
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
                    res.add(curr.data);
                    curr=curr.left;
                }else{
                    t.right=null;
                    curr=curr.right;
                }
            }
        }
        return res;
    }
}
