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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode build(int[] pre,int preS,int preE,int[] in,int inS,int inE,Map<Integer,Integer> map){
        if(preS>preE||inS>inE) return null;
        TreeNode root=new TreeNode(pre[preS]);
        int inRoot=map.get(pre[preS]);
        int nums=inRoot-preS;
        root.left=build(pre,preS+1,preS+nums,in,inS,inRoot-1,map);
        root.right=build(pre,preS+nums+1,preE,in,inRoot+1,inE,map);
        return root;
    }
}
