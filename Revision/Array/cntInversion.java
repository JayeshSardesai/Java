class Solution {
    public int inversionCount(int arr[]) {
        // code here
        return mergeSort(0, arr.length - 1, arr);
    }
    public int mergeSort(int i, int j, int arr[]) {
        if (i >= j) {
            return 0;
        }
        int mid = i + (j - i) / 2;
        int invertCnt = 0;
        invertCnt += mergeSort(i, mid, arr);
        invertCnt += mergeSort(mid + 1, j, arr);
        invertCnt += merge(i, mid, j, arr);
        return invertCnt;
    }
    public int merge(int s, int m, int e, int arr[]) {
        int[] temp = new int[e - s + 1];
        int i = s, j = m + 1, k = 0;
        int invertCnt = 0;
        while (i <= m && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                invertCnt += m - i + 1;
                temp[k++] = arr[j++];
            }
        }
        while (i <= m) {
            temp[k++] = arr[i++];
        }
        while (j <= e) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < e - s + 1; i++) {
            arr[s + i] = temp[i];
        }
        return invertCnt;
    }
}
