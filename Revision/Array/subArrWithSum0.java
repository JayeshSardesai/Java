class Solution {
    int maxLength(int arr[]) {
        // code here
        Map<Integer,Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
            if (prefixSum.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - prefixSum.get(sum));
            }
        }
        return maxLen;
    }
}
