class Solution {
    public void mergeSort(int arr[], int l, int r) {
        // code here
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
    private void merge (int arr[], int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        int[] tempArr = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if(arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }
        while (j <= r) {
            tempArr[k++] = arr[j++];
        }
        i = l;
        j = 0;
        while (j < k && i <= r){
            arr[i++] = tempArr[j++];
        }
    }
}
