/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here.
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return loop(slow);
            }
        }
        return 0;
    }
    public int loop(Node slow){
        int count=1;
        Node p=slow.next;
        while(p!=slow){
            count++;
            p=p.next;
        }
        return count;
    }
}
