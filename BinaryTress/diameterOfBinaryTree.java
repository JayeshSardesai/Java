// Brute Force Tehnique O(n^2) time complexity
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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        finddia(root);
        return max;
    }
    public void finddia(TreeNode root){
        if(root==null) return;
        int l=height(root.left);
        int r=height(root.right);
        max=Math.max(max,l+r);
        finddia(root.left);
        finddia(root.right);
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}

//Optimal approach O(N) time complexity
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
} */

class Solution {
    int max=0;
    public int diameter(Node root) {
        // code here
        finddia(root);
        return max;
    }
    public int finddia(Node root){
        if(root==null) return 0;
        int l=finddia(root.left);
        int r=finddia(root.right);
        max=Math.max(max,l+r);
        return 1+Math.max(l,r);
    }
}
