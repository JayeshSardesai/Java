/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,Node head) {
        // code here
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        Node left=head;
        Node right=head;
        while(right.next!=null){
            right=right.next;
        }
        while(left.data<right.data){
            if((left.data+right.data)==target){
                ArrayList<Integer> a=new ArrayList<>();
                a.add(left.data);
                a.add(right.data);
                arr.add(a);
                left=left.next;
                right=right.prev;
            }else if((left.data+right.data)<target){
                left=left.next;
            }else{
                right=right.prev;
            }
        }
        return arr;
    }
}
