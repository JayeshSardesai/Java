/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if(x==1){
            head=head.next;
            head.prev=null;
            return head;
        }
        int count=1;
        Node temp=head;
        while(temp!=null){
            if(count==x) break;
            count++;
            temp=temp.next;
        }
        if(temp==null) return head;
        temp.prev.next=temp.next;
        if(temp.next!=null){
            temp.next.prev=temp.prev;
        }
        temp.next=null;
        temp.prev=null;
        return head;
    }
}
