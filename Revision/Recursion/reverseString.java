class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        reverse(n-1,s);
    }
    private void reverse(int n,char[] arr){
        if(n<arr.length/2) return;
        char temp=arr[arr.length-n-1];
        arr[arr.length-n-1]=arr[n];
        arr[n]=temp;
        reverse(n-1,arr);
    }
}
