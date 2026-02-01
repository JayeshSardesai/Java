//Method 1
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
    int res=0;
    public int countNodes(TreeNode root) {
        count(root);
        return res;
    }
    public void count(TreeNode root){
        if(root==null) return;
        res++;
        count(root.left);
        count(root.right);
    }
}
//Method 2
// User function Template for Java

class Solution {
    public static int countNodes(Node root) {
        // Code here
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
