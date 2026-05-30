class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt=1;
        StringBuilder str=new StringBuilder(a); 
        while(str.length()<b.length()){
            str.append(a);
            cnt++;
        }
        if(str.toString().contains(b)) return cnt;
        str.append(a);
        cnt++;
        if(str.toString().contains(b)) return cnt;
        return -1;
    }
}
