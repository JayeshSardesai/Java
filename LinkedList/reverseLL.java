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
    public ListNode reverseList(ListNode head) {
        // if(head==null||head.next==null) return head;
        // ListNode curr=head;
        // ListNode prev=null;
        // ListNode front=curr.next;
        // while(front!=null){
        //     curr.next=prev;
        //     prev=curr;
        //     curr=front;
        //     front=front.next;
        // }
        // curr.next=prev;
        // return curr;
        return reverse(head);
    }
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newNode=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newNode;
    }
}
