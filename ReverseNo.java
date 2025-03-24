//Recursion approach.

class Solution {
    public void reverse(int arr[],int start,int end){
        if(start<end){
            int c=arr[start];
            arr[start]=arr[end];
            arr[end]=c;
            reverse(arr,start+1,end-1);
        }
    }
    public void reverseArray(int arr[]) {
        reverse(arr,0,arr.length-1);
    }
}

//For loop approach.

class Solution {
    public void reverseArray(int arr[]) {
        for(int i=0;i<arr.length/2;i++){
             int c=arr[i];
             arr[i]=arr[arr.length-i-1];
             arr[arr.length-i-1]=c;
         }
    }
}
