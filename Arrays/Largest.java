class Solution {
    public static int largest(int[] arr) {
        // code here
        int large=arr[0];
        for(int i=1;i<arr.length;i++){
            if(large<arr[i]){
                large=arr[i];
            }
        }
        return large;
    }
}
