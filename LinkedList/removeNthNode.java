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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode t=head;
        int cnt=0;
        while(t!=null){
            cnt++;
            t=t.next;
        }
        if(cnt-n+1==1) return head=head.next;
        ListNode temp=head;
        ListNode prev=null;
        int count=0;
        while(temp!=null){
            count++;
            if(count==cnt-n+1){
                prev.next=prev.next.next;
                temp.next=null;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
}
