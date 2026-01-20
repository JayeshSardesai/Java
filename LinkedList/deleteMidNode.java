/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null) return null;
        // ListNode temp=head;
        // int count=0;
        // while(temp!=null){
        //     count++;
        //     temp=temp.next;
        // }
        // int n=count;
        // count=0;
        // temp=head;
        // while(temp!=null){
        //     if((count+1)==n/2){
        //         ListNode t=temp.next;
        //         temp.next=temp.next.next;
        //         t.next=null;
        //         break;
        //     }
        //     count++;
        //     temp=temp.next;
        // }
        ListNode slow=head;
        ListNode fast=head;
        ListNode m=null;
        while(fast!=null&&fast.next!=null){
            m=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode t=m.next;
        m.next=m.next.next;
        t.next=null;
        return head;
    }
}
