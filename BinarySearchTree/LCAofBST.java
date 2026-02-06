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
    public Node LCA(Node root, Node n1, Node n2) {
        // code here
        if(root==null) return root;
        int curr=root.data;
        if(curr<n1.data&&curr<n2.data) return LCA(root.right,n1,n2);
        else if(curr>n1.data&&curr>n2.data) return LCA(root.left,n1,n2);
        return root;
    }
}
