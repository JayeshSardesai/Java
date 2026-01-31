//Maximum Width = Number of nodes at particular level
/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    int maxWidth(Node root) {
        //  code here
        if(root==null) return 0;
        Queue<Node> q=new LinkedList<>();
        int ans=0;
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                Node n=q.poll();
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            ans=Math.max(ans,s);
        }  
        return ans;
    }
}
