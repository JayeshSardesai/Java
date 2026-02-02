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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode build(int[] po,int poS,int poE,int[] in,int inS,int inE,Map<Integer,Integer> map){
        if(poS>poE||inS>inE) return null;
        TreeNode root=new TreeNode(po[poE]);
        int inRoot=map.get(po[poE]);
        int nums=inRoot-inS;
        root.left=build(po,poS,poS+nums-1,in,inS,inRoot-1,map);
        root.right=build(po,poS+nums,poE-1,in,inRoot+1,inE,map);
        return root;
    }
}
