/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(Map<TreeNode,TreeNode> parent,TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        markParent(parent,root);
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int level=0;
        while(!q.isEmpty()){
            int s=q.size();
            if(level==k) break;
            level++;
            for(int i=0;i<s;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null&&visited.get(curr.left)==null){
                    visited.put(curr.left,true);
                    q.offer(curr.left);
                }
                if(curr.right!=null&&visited.get(curr.right)==null){
                    visited.put(curr.right,true);
                    q.offer(curr.right);
                }
                if(parent.get(curr)!=null&&visited.get(parent.get(curr))==null){
                    visited.put(parent.get(curr),true);
                    q.offer(parent.get(curr));
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            res.add(curr.val);
        }
        return res;
    }
}
