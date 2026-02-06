/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBST(Node root) {
        // code here
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean check(Node root,long min,long max){
        if(root==null) return true;
        if(root.data>=max||root.data<=min) return false;
        return check(root.left,min,root.data)&&check(root.right,root.data,max);
    }
}
