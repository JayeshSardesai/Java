/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int cnt=0;
    int res;
    public int kthSmallest(Node root, int k) {
        // code here
        res=-1;
        helper(root,k);
        return res;
    }
    public void helper(Node root,int k){
        if(root==null) return;
        helper(root.left,k);
        cnt++;
        if(cnt==k){
            res=root.data;
            return;
        }
        helper(root.right,k);
    }
}
