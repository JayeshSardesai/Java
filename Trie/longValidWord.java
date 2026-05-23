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
class Trie{
    private Node root;
    public Trie(){
        root=new Node();
    }
    public void insert(String word){
        Node nd=root;
        for(int i=0;i<word.length();i++){
            if(!nd.containsKey(word.charAt(i))){
                nd.put(word.charAt(i),new Node());
            }
            nd=nd.get(word.charAt(i));
        }
        nd.setEnd();
    }
    public boolean isPrefix(String word) {
        Node nd=root;
        for(int i=0;i<word.length();i++){
            if(!nd.containsKey(word.charAt(i))){
                return false;
            }
            nd=nd.get(word.charAt(i));
        }
        return true;
    }
}
class Solution {
    public String longestValidWord(String[] words) {
        // code here
        Trie tr=new Trie();
        for(int i=0;i<words.length;i++) tr.insert(words[i]);
        String ans="";
        for(int i=0;i<words.length;i++){
            if(tr.isPrefix(words[i])){
                if(words[i].length()>ans.length()){
                    ans=words[i];
                }else if(words[i].length()==ans.length()&&words[i].compareTo(ans)<0){
                    ans=words[i];
                }
            }
        }
        return ans;
    }
}
