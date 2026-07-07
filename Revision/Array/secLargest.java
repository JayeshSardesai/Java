class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = arr[0];
        int secLargest = -1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            if (largest < arr[i]){
                temp = largest;
                largest = arr[i];
            }
            if ((temp != arr[i] && temp > secLargest) 
            || (arr[i] > secLargest && arr[i] < largest)) {
                secLargest = temp;
            }
        }
        return secLargest;
    }
}
