class Solution {
    public static int countSubstring(String s) {
        // code here
        int maxsub=0;
        int a=-1,b=-1,c=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') a=i;
            if(s.charAt(i)=='b') b=i;
            if(s.charAt(i)=='c') c=i;
            if(a!=-1&&b!=-1&&c!=-1) maxsub=maxsub+Math.min(a,Math.min(b,c))+1;
        }
        return maxsub;
    }
}
