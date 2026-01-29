/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> res;
    public ArrayList<Integer> rightView(Node root) {
        // code here
        res=new ArrayList<>();
        helper(root,0);
        return res;
    }
    public void helper(Node root,int level){
        if(root==null) return;
        if(level==res.size()) res.add(root.data);
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}
