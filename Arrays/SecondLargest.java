

// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here 
        int large=arr[0];
        int secondLarge=-1;
        for(int i=0;i<arr.length;i++){
            if(large<arr[i]){
                large=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<large&&secondLarge<arr[i]){
                secondLarge=arr[i];
            }
        }
        return secondLarge;
    }
}
