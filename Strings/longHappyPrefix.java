// Used KMP approach to solve this.
class Solution {
    public String longestPrefix(String s) {
        return s.substring(0,pArray(s));
    }
    private int pArray(String s){
        int n=s.length();
        int[] p=new int[n];
        for(int i=1;i<n;i++){
            int j=p[i-1];
            while(j>0&&s.charAt(i)!=s.charAt(j)){
                j=p[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            p[i]=j;
        }
        return p[n-1];
    }
}
