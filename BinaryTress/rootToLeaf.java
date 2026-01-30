/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    // public static ArrayList<ArrayList<Integer>> res;
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer> >res=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        helper(root,l,res);
        return res;
    }
    public static void helper(Node root,ArrayList<Integer> l,ArrayList<ArrayList<Integer>> res){
        if(root==null) return;
        l.add(root.data);
        if(root.left==null&&root.right==null){
            res.add(new ArrayList<>(l));
        }else{
            helper(root.left,l,res);
            helper(root.right,l,res);
        }
        l.remove(l.size()-1);
    }
}
