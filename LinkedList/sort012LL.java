/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        if(head==null||head.next==null) return head;
        // code here
        Node zero=null;
        Node one=null;
        Node two=null;
        Node zero1=null;
        Node one1=null;
        Node two1=null;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                if(zero==null){
                    zero=zero1=temp;
                }else{
                    zero.next=temp;
                    zero=zero.next;
                }
            }else if(temp.data==1){
                if(one==null){
                    one=one1=temp;
                }else{
                    one.next=temp;
                    one=one.next;
                }
            }else if(temp.data==2){
                if(two==null){
                    two=two1=temp;
                }else{
                    two.next=temp;
                    two=two.next;
                }
            }
            temp=temp.next;
        }
        if(zero!=null) zero.next=one1;
        if(one!=null) one.next=two1;
        if(two!=null) two.next=null;
        if(one==null&&zero!=null&&two!=null) zero.next=two1;
        if(zero==null&&one!=null) return one1;
        if(zero==null&&one==null) return two1;
        return zero1;
    }
}
