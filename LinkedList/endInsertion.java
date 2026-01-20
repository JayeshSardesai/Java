
// class Node{
//     int data;
//     Node next;

//     Node(int x){
//         data = x;
//         next = null;
//     }
// }
class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node temp=new Node(x);
        Node mover=head;
        if(head==null) return temp;
        while(mover.next!=null){
            mover=mover.next;
        }
        mover.next=temp;
        return head;
    }
}
