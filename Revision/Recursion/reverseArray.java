class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int n=arr.length;
        reverse(n-1,arr);
    }
    private void reverse(int n,int[] arr){
        if(n<arr.length/2) return;
        arr[n]=arr[arr.length-n-1]+arr[n]-(arr[arr.length-n-1]=arr[n]);
        reverse(n-1,arr);
    }
}
