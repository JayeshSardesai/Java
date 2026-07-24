class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, sum + nums[i]);
            sum = Math.max(0, sum + nums[i]);
        }
        return maxSum;
    }
}
