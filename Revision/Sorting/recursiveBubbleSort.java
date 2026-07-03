class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        bubbleSt(arr,arr.length);
    }
    public void bubbleSt(int[] arr,int n) {
        if(n == 1) return;
        for (int j = 0;j < n - 1;j++) {
            if(arr[j] > arr[j+1]) {
                arr[j] = (arr[j] + arr[j+1]) - (arr[j + 1] = arr[j]);
            }
        }
        bubbleSt(arr, n-1);
    }
}
