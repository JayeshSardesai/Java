/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> res;
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        res=new ArrayList<>();
        traverse(root);
        return res;
    }
    public void traverse(Node root){
        if(root==null) return ;
        traverse(root.left);
        traverse(root.right);
        res.add(root.data);
    }
}
