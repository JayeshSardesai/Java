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
    Node first,last,middle,prev;
    public void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null&&root.data<prev.data){
            if(first==null){
                first=prev;
                middle=root;
            }else last=root;
        }
        prev=root;
        inorder(root.right);
    }
    void correctBST(Node root) {
        // code here.
        first=middle=last=null;
        prev=new Node(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null&&last!=null){
            int v=first.data;
            first.data=last.data;
            last.data=v;
        }else if(first!=null&&middle!=null){
            int v=first.data;
            first.data=middle.data;
            middle.data=v;
        }
    }
}
