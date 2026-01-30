/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    public boolean isSymmetric(Node root) {
        // code here
        return root==null||isSym(root.left,root.right);
    }
    public boolean isSym(Node l,Node r){
        if(l==null||r==null) return l==r;
        if(l.data!=r.data) return false;
        return isSym(l.left,r.right)&&isSym(l.right,r.left);
    }
}
