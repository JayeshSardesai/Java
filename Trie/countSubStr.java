class Node{
    Node[] link=new Node[26];
    boolean flg=false;
    public Node(){

    }
    boolean containsKey(char ch){
        return (link[ch-'a']!=null);
    }
    void put(char ch,Node nd){
        link[ch-'a']=nd;
    }
    Node get(char ch){
        return link[ch-'a'];
    }
    void setEnd(){
        flg=true;
    }
    boolean isEnd(){
        return flg;
    }
}
class Solution {
    public static int countSubs(String s) {
        // code here
        int cnt=0;
        Node root=new Node();
        for(int i=0;i<s.length();i++){
            Node nd=root;
            for(int j=i;j<s.length();j++){
                if(!nd.containsKey(s.charAt(j))){
                    cnt++;
                    nd.put(s.charAt(j),new Node());
                }
                nd=nd.get(s.charAt(j));
            }
        }
        return cnt;
    }
}
