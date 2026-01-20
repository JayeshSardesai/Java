/*
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node addNode(Node head, int p, int x) {
        // code here
        Node temp=head;
        int count=0;
        while(temp!=null){
            if(count==p) break;
            count++;
            temp=temp.next;
        }
        if(temp==null) return head;
        Node newNode=new Node(x);
        newNode.prev=temp;
        newNode.next=temp.next;
        temp.next=newNode;
        if(newNode.next!=null) temp.next.prev=newNode;
        return head;
    }
}
