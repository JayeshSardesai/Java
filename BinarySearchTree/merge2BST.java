/*
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // code here
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        inorder(root1,arr1);
        inorder(root2,arr2);
        int i=0,j=0;
        ArrayList<Integer> res=new ArrayList<>();
        while(i<arr1.size()&&j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)) res.add(arr1.get(i++));
            else res.add(arr2.get(j++));
        }
        while(i<arr1.size()) res.add(arr1.get(i++));
        while(j<arr2.size()) res.add(arr2.get(j++));
        return res;
    }
    public void inorder(Node root,ArrayList<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
}
