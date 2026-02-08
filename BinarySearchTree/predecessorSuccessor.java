/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node succ=null;
        Node pred=null;
        Node temp=root;
        while(temp!=null){
            if(temp.data<=key){
                temp=temp.right;
            }else{
                succ=temp;
                temp=temp.left;
            }
        }
        temp=root;
        while(temp!=null){
            if(temp.data>=key){
                temp=temp.left;
            }else{
                pred=temp;
                temp=temp.right;
            }
        }
        ArrayList<Node> res=new ArrayList<>();
        res.add(pred);
        res.add(succ);
        return res;
    }
}
