/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public static int findMax(Node root) {
        // code here
        int max=0;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node t=q.poll();
            max=Math.max(max,t.data);
            if(t.left!=null){
                q.offer(t.left);
            }
            if(t.right!=null){
                q.offer(t.right);
            }
        }
        return max;
    }
    public static int findMin(Node root) {
        // code here
        int min=Integer.MAX_VALUE;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node t=q.poll();
            min=Math.min(min,t.data);
            if(t.left!=null){
                q.offer(t.left);
            }
            if(t.right!=null){
                q.offer(t.right);
            }
        }
        return min;
    }
}
