// Here negative number is not palindrome.
class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        if(x<0) return false;
        int num=x;
        while(x>0){
            int digit=x%10;
            rev=(rev*10)+digit;
            x=x/10;
        }
        if(rev==num) return true;
        return false;
    }
}

// Here negative numbers can also be palindrome.
class Solution {
    public boolean isPalindrome(int n) {
        // code here
        int rev=0;
        if(n<0) n=-n;
        int num=n;
        while(n>0){
            int digit=n%10;
            rev=(rev*10)+digit;
            n=n/10;
        }
        if(rev==num) return true;
        return false;
    }
}
