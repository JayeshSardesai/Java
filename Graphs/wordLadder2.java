// User function Template for Java

class Solution {
    HashMap<String,Integer> map;
    String b;
    ArrayList<ArrayList<String>> ans;
    private void dfs(String word,List<String> seq){
        if(word.equals(b)){
            ArrayList<String> temp=new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        int step=map.get(word);
        for(int i=0;i<word.length();i++){
            for(char c='a';c<='z';c++){
                char[] replace=word.toCharArray();
                replace[i]=c;
                String str=new String(replace);
                if(map.containsKey(str)&&map.get(str)+1==step){
                    seq.add(str);
                    dfs(str,seq);
                    seq.remove(str);
                }
            }
        }
    }
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        map=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        b=startWord;
        q.add(startWord);
        Set<String> s=new HashSet<>();
        for(int i=0;i<wordList.length;i++) s.add(wordList[i]);
        map.put(startWord,1);
        s.remove(startWord);
        int size=startWord.length();
        while(!q.isEmpty()){
            String word=q.peek();
            int step=map.get(word);
            q.remove();
            if(targetWord.equals(word)==true) break;
            for(int i=0;i<size;i++){
                for(char c='a';c<='z';c++){
                    char[] replace=word.toCharArray();
                    replace[i]=c;
                    String str=new String(replace);
                    if(s.contains(str)==true){
                        q.add(str);
                        s.remove(str);
                        map.put(str,step+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(map.containsKey(targetWord)){
            ArrayList<String> seq=new ArrayList<>();
            seq.add(targetWord);
            dfs(targetWord,seq);
        }
        return ans;
    }
}
