class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        int length = arr.length;
        insertSt(arr,length,1);
    }
    public void insertSt(int arr[], int n, int i){
        if (i == n) return;
        int key = arr[i];
        int j = i - 1;
        while(j >=0 && key < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        insertSt(arr,n,i+1);
    }
}
