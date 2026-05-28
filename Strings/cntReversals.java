class Solution {
    public int countMinReversals(String s) {
        // code here
        int openCnt=0;
        int closeCnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                openCnt++;
            }else{
                if(openCnt>0){
                    openCnt--;
                }else{
                    closeCnt++;
                }
            }
        }
        if((openCnt+closeCnt)%2!=0) return -1;
        return ((openCnt+1)/2+(closeCnt+1)/2);
    }
}
