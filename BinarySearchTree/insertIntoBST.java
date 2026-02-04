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
    public Node insert(Node root, int key) {
        // code here
        if(root==null) return new Node(key);
        Node curr=root;
        while(true){
            if(curr.data<key){
                if(curr.right!=null) curr=curr.right;
                else{
                    Node temp=new Node(key);
                    curr.right=temp;
                    break;
                }
            }else{
                if(curr.left!=null) curr=curr.left;
                else{
                    Node temp=new Node(key);
                    curr.left=temp;
                    break;
                }
            }
        }
        return root;
    }
}
