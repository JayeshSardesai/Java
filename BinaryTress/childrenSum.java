/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        int l=root.left!=null?root.left.data:0;
        int r=root.right!=null?root.right.data:0;
        if(root.data!=(l+r)) return false;
        return isSumProperty(root.left)&&isSumProperty(root.right);
    }
}
