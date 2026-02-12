// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }
class NodeValue {
    int minVal, maxVal, sum;
    NodeValue(int minVal, int maxVal, int sum) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.sum = sum;
    }
}
class Solution {
    static public NodeValue helper(Node root) {
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        if (left.maxVal < root.data && root.data < right.minVal) {
            return new NodeValue(Math.min(left.minVal, root.data),Math.max(right.maxVal, root.data),left.sum+right.sum+1);
        }

        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.sum,right.sum));
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        return Math.max(0,helper(root).sum);
    }
}
