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
class NodeValue {
    int minVal, maxVal, sum;
    boolean isBST;
    NodeValue(int minVal, int maxVal, int sum, boolean isBST) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.sum = sum;
        this.isBST = isBST;
    }
}
class Solution {
    int maxsum = 0;
    public NodeValue helper(TreeNode root) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        if (left.isBST && right.isBST &&
            left.maxVal < root.val && root.val < right.minVal) {
            int currsum = left.sum + right.sum + root.val;
            maxsum = Math.max(maxsum, currsum);
            return new NodeValue(Math.min(left.minVal, root.val),Math.max(right.maxVal, root.val),currsum,true);
        }

        return new NodeValue(0, 0, 0, false);
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxsum;
    }
}
