// Using Resursion.
class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^A-Za-z0-9]","");
        s=s.toLowerCase();
        return checkPalindrome(0,s.length()-1,s);    
    }
    private boolean checkPalindrome(int start,int end,String str){
        if(start>=end) return true;
        boolean res=false;
        if(str.charAt(start)==str.charAt(end)){
            res=checkPalindrome(start+1,end-1,str);
        }
        return res;
    }
}
// Using two pointers.
class Solution {
    public boolean isPalinSent(String s) {
        // code here
        s=s.replaceAll("[^A-Za-z0-9]","");
        s=s.toLowerCase();
        boolean res=true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                res=false;
                break;
            }
        }
        return res;
    }
}
