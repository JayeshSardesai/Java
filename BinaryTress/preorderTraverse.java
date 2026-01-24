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
    ArrayList<Integer> res;
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        res=new ArrayList<>();
        traverse(root);
        return res;
    }
    public void traverse(Node root){
        if(root==null) return;
        res.add(root.data);
        traverse(root.left);
        traverse(root.right);
    }
}
