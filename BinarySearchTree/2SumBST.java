/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Iter{
    Stack<Node> stk=new Stack<>();
    boolean reverse=true;
    Iter(Node root,boolean isRev){
        reverse=isRev;
        pushAll(root);
    }
    void pushAll(Node root){
        while(root!=null){
            stk.push(root);
            if(reverse==true) root=root.right;
            else root=root.left; 
        }
    }
    int next(){
        Node temp=stk.pop();
        if(reverse==false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.data;
    }
}
class Solution {
    boolean findTarget(Node root, int target) {
        // Write your code here
        if(root==null) return false;
        Iter l=new Iter(root,false);
        Iter r=new Iter(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if((i+j)==target) return true;
            else if((i+j)<target) i=l.next();
            else j=r.next();
        }
        return false;
    }
}
