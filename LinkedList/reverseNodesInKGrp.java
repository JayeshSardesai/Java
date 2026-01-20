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
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newNode=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
    public ListNode findK(ListNode temp,int k){
        k-=1;
        while(temp!=null&&k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode kNode=findK(temp,k);
            if(kNode==null){
                if(prev!=null) prev.next=temp;
                break;
            }
            ListNode nextNode=kNode.next;
            kNode.next=null;
            reverse(temp);
            if(temp==head){
                head=kNode;
            }else{
                prev.next=kNode;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
    }
}
