class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low < high) {
            int splitI = partition(arr, low, high);
            quickSort(arr, low, splitI - 1);
            quickSort(arr, splitI + 1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // code here
        int pivot = arr[low];
        int i = high + 1;
        int j = high;
        while(j > low) {
            if(arr[j] >= pivot){
                i--;
                arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
            }
            j--;
        }
        arr[i - 1] = (arr[i - 1] + arr[low]) - (arr[low] = arr[i - 1]);
        return i - 1;
    }
}
