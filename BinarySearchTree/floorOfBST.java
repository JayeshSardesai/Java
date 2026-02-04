/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int x) {
        // code here
        int res=-1;
        while(root!=null){
            if(root.data==x){
                return root.data;
            }
            if(root.data<x){
                if(res==-1||root.data>res) res=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return res;
    }
}
