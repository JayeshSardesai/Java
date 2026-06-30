class Solution {
    void selectionSort(int[] arr) {
        // code here
        for (int i = 0;i < arr.length;i++) {
            for (int j = i + 1;j < arr.length;j++) {
                if (arr[j] < arr[i]) {
                    arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
                }
            }
        }
    }
}
