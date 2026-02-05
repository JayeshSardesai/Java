// Deleting Node by physically joining the right subtree to the rightmost node of the left subtree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val==key) return helper(root);
        TreeNode temp=root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null&&root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                if(root.right!=null&&root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }else{
                    root=root.right;
                }
            }
        }
        return temp;
    }
    public TreeNode helper(TreeNode root){
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        else{
            TreeNode rightChild=root.right;
            TreeNode lastRight=rightmost(root.left);
            lastRight.right=rightChild;
            return root.left;
        }
    }
    public TreeNode rightmost(TreeNode root){
        if(root.right==null) return root;
        return rightmost(root.right);
    }
}


// Approach 2: In this we will simply replace the value of the node with the leftmost node value of the right subtree from that given key node
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node delNode(Node root, int x) {
        // code here
        if(root==null) return root;
        if(root.data==x) return helper(root);
        Node temp=root;
        while(root!=null){
            if(root.data>x){
                if(root.left!=null&&root.left.data==x){
                    root.left=helper(root.left);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                if(root.right!=null&&root.right.data==x){
                    root.right=helper(root.right);
                    break;
                }else{
                    root=root.right;
                }
            }
        }
        return temp;
    }
    public Node helper(Node root){
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        Node parent=root;
        Node succ=root.right;
        while(succ.left!=null){
            parent=succ;
            succ=succ.left;
        }
        root.data=succ.data;
        if(parent.left==succ) parent.left=succ.right;
        else parent.right=succ.right;
        return root;
    }
}
