class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sumCnt = 0;
        int sum = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int pre = sum - k;
            if (prefix.getOrDefault(pre, 0) != 0) {
                sumCnt += prefix.get(pre);
            }
            prefix.put(sum, prefix.getOrDefault(sum,0) + 1);
        }
        return sumCnt;
    }
}
