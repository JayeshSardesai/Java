/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    boolean isLeaf(Node root){
        return (root.left==null&&root.right==null);
    }
    void leftboundry(Node root,ArrayList<Integer> res){
        Node curr=root.left;
        while(curr!=null){
            if(isLeaf(curr)==false) res.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    void rightboundry(Node root,ArrayList<Integer> res){
        Node curr=root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }
    void leaves(Node root,ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left!=null) leaves(root.left,res);
        if(root.right!=null) leaves(root.right,res);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        if(isLeaf(root)==false) res.add(root.data);
        leftboundry(root,res);
        leaves(root,res);
        rightboundry(root,res);
        return res;
    }
}
