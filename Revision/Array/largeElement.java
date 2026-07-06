class Solution {
    public static int largest(int[] arr) {
        // code here
        int largeEle = 0;
        int n = arr.length;
        for(int i = 0;i < n; i++) {
            largeEle = Math.max(largeEle, arr[i]);
        }
        return largeEle;
    }
}
