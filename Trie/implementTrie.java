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
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node nd=root;
        for(int i=0;i<word.length();i++){
            if(!nd.containsKey(word.charAt(i))){
                nd.put(word.charAt(i),new Node());
                
            }
            nd=nd.get(word.charAt(i));
        }
        nd.setEnd();
    }
    
    public boolean search(String word) {
        Node nd=root;
        for(int i=0;i<word.length();i++){
            if(!nd.containsKey(word.charAt(i))){
                return false;
            }
            nd=nd.get(word.charAt(i));
        }
        return nd.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node nd=root;
        for(int i=0;i<prefix.length();i++){
            if(!nd.containsKey(prefix.charAt(i))){
                return false;
            }
            nd=nd.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
