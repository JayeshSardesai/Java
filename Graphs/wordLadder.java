class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String> s=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            s.add(wordList[i]);
        }
        s.remove(startWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().second;
            q.remove();
            if(targetWord.equals(word)==true) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replace=word.toCharArray();
                    replace[i]=ch;
                    String temp=new String(replace);
                    if(s.contains(temp)==true){
                        s.remove(temp);
                        q.add(new Pair(temp,step+1));
                    }
                }
            }
        }
        return 0;
    }
}
