//Elements from the collumn sorted by level
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
class Tuple{
    TreeNode node;
    int row,col;
    Tuple(TreeNode node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            TreeNode node=t.node;
            int x=t.row;
            int y=t.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null) q.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null) q.offer(new Tuple(node.right,x+1,y+1));
        }
        List<List<Integer>> res=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> temp:map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> t:temp.values()){
                while(!t.isEmpty()) res.get(res.size()-1).add(t.poll());
            }
        }
        return res;
    }
}

//Elements from column doesnot sorted by level
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Tuple{
    Node node;
    int row,col;
    Tuple(Node node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            Node node=t.node;
            int x=t.row;
            map.putIfAbsent(x,new ArrayList<>());
            map.get(x).add(node.data);
            if(node.left!=null) q.offer(new Tuple(node.left,x-1,t.col+1));
            if(node.right!=null) q.offer(new Tuple(node.right,x+1,t.col+1));
        }
        return new ArrayList<>(map.values());
    }
}
