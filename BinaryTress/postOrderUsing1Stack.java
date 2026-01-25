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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stk=new Stack<>();
        List<Integer> res=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null||!stk.isEmpty()){
            if(curr!=null){
                stk.push(curr);
                curr=curr.left;
            }else{
                TreeNode temp=stk.peek().right;
                if(temp==null){
                    temp=stk.pop();
                    res.add(temp.val);
                    while(!stk.isEmpty()&&temp==stk.peek().right){
                        temp=stk.pop();
                        res.add(temp.val);
                    }
                }else{
                    curr=temp;
                }
            }
        }
        return res;
    }
}
