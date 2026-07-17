class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
         Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int remain = sum - k;
            if (remain == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (map.getOrDefault(sum,0) == 0) {
                map.put(sum,i);
            }
            if(map.getOrDefault(remain,0) != 0) {
                maxLen = Math.max(maxLen, i - map.get(remain) + 1);
            }
        }
        return maxLen;
    }
}
