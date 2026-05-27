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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        int[] ans=new int[m];
        Arrays.sort(nums);
        Trie tr=new Trie();
        int[][] ofQuery=new int[m][3];
        for(int i=0;i<m;i++){
            ofQuery[i][0]=queries[i][1];
            ofQuery[i][1]=queries[i][0];
            ofQuery[i][2]=i;
        }
        int j=0;
        Arrays.sort(ofQuery,(a,b)->a[0]-b[0]);
        for(int[] query:ofQuery){
            int x=query[1];
            int a=query[0];
            int i=query[2];
            while(j<n&&nums[j]<=a){
                tr.insert(nums[j]);
                j++;
            }
            if(j==0){
                ans[i]=-1;
            }else{
                ans[i]=tr.getMax(x);
            }
        }
        return ans;
    }
}
