// KMP Approach.
class Solution {
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        String str=s+'$'+rev;
        int[] p=pArray(str);
        int ind=p[p.length-1];
        return rev.substring(0,n-ind)+s;
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

// Normal Approach using reversing string and using loop.
class Solution {
    public String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.substring(0,n-i).equals(rev.substring(i,n))){
                return rev.substring(0,i)+s;
            }
        }
        return rev+s;
    }
}
