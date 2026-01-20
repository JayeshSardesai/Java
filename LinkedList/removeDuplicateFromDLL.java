// User function Template for Java

class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        if(head==null||head.next==null) return head;
        Node temp=head;
        while(temp!=null){
            while(temp.next!=null&&temp.data==temp.next.data){
                temp.next=temp.next.next;
                if(temp.next!=null) temp.next.prev=temp;
            }
            temp=temp.next;
        }
        return head;
    }
}
