/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    // public Node reverse(Node head){
    //     if(head==null||head.next==null) return head;
    //     Node t=reverse(head.next);
    //     head.next.next=head;
    //     head.next=null;
    //     return t;
    // }
    public int helper(Node head){
        if(head==null) return 1;
        int carry=helper(head.next);
        head.data=head.data+carry;
        if(head.data<10) return 0;
        head.data=0;
        return 1;
    }
    public Node addOne(Node head) {
        // code here
        if(head==null) return head;
        // head=reverse(head);
        // Node temp=head;
        // int carry=1;
        // while(temp!=null){
        //     temp.data=temp.data+carry;
        //     if(temp.data<10){
        //         carry=0;
        //         break;
        //     }else{
        //         carry=1;
        //         temp.data=0;
        //     }
        //     temp=temp.next;
        // }
        // if(carry==1){
        //     Node n=new Node(1);
        //     head=reverse(head);
        //     n.next=head;
        //     return n;
        // }
        // return reverse(head);
        int carry=helper(head);
        if(carry==1){
            Node t=new Node(1);
            t.next=head;
            return t;
        }
        return head;
    }
}
