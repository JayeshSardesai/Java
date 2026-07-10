class Solution {
    static void rotateArr(int arr[], int d) {
        // code here
        int n = arr.length;
        d = d % n;
        reverse(0, d - 1, arr);
        reverse(d, n - 1,arr);
        reverse(0, n - 1,arr);
    }
    static void reverse(int i, int j, int[] arr) {
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
