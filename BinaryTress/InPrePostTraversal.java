// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Pair{
    int val;
    Node node;
    Pair(Node node,int val){
        this.val=val;
        this.node=node;
    }
}
class Main {
    List<Integer> pre;
    List<Integer> in;
    List<Integer> pos;
    public void traversal(Node root){
        Stack<Pair> stk=new Stack<>();
        pre=new ArrayList<>();
        in=new ArrayList<>();
        pos=new ArrayList<>();
        stk.push(new Pair(root,1));
        while(!stk.isEmpty()){
            Pair temp=stk.pop();
            if(temp.val==1){
                pre.add(temp.node.data);
                temp.val++;
                stk.push(temp);
                if(temp.node.left!=null){
                    stk.push(new Pair(temp.node.left,1));
                }
            }else if(temp.val==2){
                in.add(temp.node.data);
                temp.val++;
                stk.push(temp);
                if(temp.node.right!=null){
                    stk.push(new Pair(temp.node.right,1));
                }
            }
            else{
                pos.add(temp.node.data);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Main obj = new Main();
        obj.traversal(root);
        System.out.println("Preorder  : " + obj.pre);
        System.out.println("Inorder   : " + obj.in);
        System.out.println("Postorder : " + obj.pos);
    }
}
