class Solution {
    public boolean isPalindrome(int x) {
        char[] num=String.valueOf(x).toCharArray();
        for(int i=0;i<num.length/2;i++){
            if(num[i]!=num[num.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
