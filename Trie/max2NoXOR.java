class Node{
    Node[] link=new Node[2];
    public Node(){
    }
    boolean containsKey(int i){
        return (link[i]!=null);
    }
    void put(int i,Node nd){
        link[i]=nd;
    }
    Node get(int i){
        return link[i];
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    public void insert(int num) {
        Node nd=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!nd.containsKey(bit)){
                nd.put(bit,new Node());
            }
            nd=nd.get(bit);
        }
    }
    public int getMax(int num){
        Node nd=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(nd.containsKey(1-bit)){
                max=max | (1<<i);
                nd=nd.get(1-bit);
            }else{
                nd=nd.get(bit);
            }
        }
        return max;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=Integer.MIN_VALUE;
        Trie bt=new Trie();
        for(int i=0;i<nums.length;i++){
            bt.insert(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,bt.getMax(nums[i]));
        }
        return max;
    }
}
