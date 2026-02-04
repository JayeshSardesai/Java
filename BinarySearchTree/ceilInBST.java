/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int res;
    int findCeil(Node root, int x) {
        res=-1;
        find(root,x);
        return res;
    }
    void find(Node root,int x){
        if(root==null) return;
        if(root.data==x){
            res=root.data;
            return;
        }
        if(root.data>x){
            if(res==-1||root.data<res) res=root.data;
            find(root.left,x);
        }else{
            find(root.right,x);
        }
    }
}
