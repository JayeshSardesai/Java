/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    int cnt=0;
    int res;
    public int kthLargest(Node root, int k) {
        // Your code here
        res=-1;
        help(root);
        k=cnt-k+1;
        cnt=0;
        helper(root,k);
        return res;
    }
    public void help(Node root){
        if(root==null) return;
        help(root.left);
        cnt++;
        help(root.right);
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
