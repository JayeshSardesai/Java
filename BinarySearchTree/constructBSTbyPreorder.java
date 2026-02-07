// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int i=0;
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        return helper(pre,Integer.MAX_VALUE);
    }
    public Node helper(int[] preorder,int bound){
        if(i==preorder.length||preorder[i]>bound) return null;
        Node root=new Node(preorder[i++]);
        root.left=helper(preorder,root.data);
        root.right=helper(preorder,bound);
        return root;
    }
}
