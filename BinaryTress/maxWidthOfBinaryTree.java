/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    int num;
    TreeNode node;
    Pair(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        int ans=0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int s=q.size();
            int f=0,l=0;
            int min=q.peek().num;
            for(int i=0;i<s;i++){
                int curr=q.peek().num-min;
                TreeNode n=q.peek().node;
                q.poll();
                if(i==0) f=curr;
                if(i==s-1) l=curr;
                if(n.left!=null) q.offer(new Pair(n.left,curr*2+1));
                if(n.right!=null) q.offer(new Pair(n.right,curr*2+2));
            }
            ans=Math.max(ans,l-f+1);
        }  
        return ans;
    }
}
