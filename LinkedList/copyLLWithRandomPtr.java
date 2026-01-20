/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null){
            Node newNode=new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null){
            Node copy=temp.next;
            copy.random=(temp.random!=null)?temp.random.next:null;
            temp=temp.next.next;
        }
        Node dummy=new Node(0);
        Node res=dummy;
        temp=head;
        while(temp!=null){
            Node copy=temp.next;
            temp.next=copy.next;
            res.next=copy;
            res=copy;
            temp=temp.next;
        }
        return dummy.next;
    }
}
