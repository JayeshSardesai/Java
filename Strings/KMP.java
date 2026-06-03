class Solution {
    public int strStr(String haystack, String needle) {
        int i=0,j=0;
        int[] p=pArray(needle);
        int n=haystack.length();
        int ans=-1;
        int m=needle.length();
        while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0){
                    j=p[j-1];
                }else{
                    i++;
                }
            }
            if(j==m){
                ans=i-m;
                break;
            }
        }
        return ans;
    }
    private int[] pArray(String s){
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
        return p;
    }
}
