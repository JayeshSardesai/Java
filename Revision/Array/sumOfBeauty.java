class Solution {
    public int sumOfBeauties(int[] nums) {
        int sum = 0;
        int n = nums.length;
        if (n < 3) return sum;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            prefix[i] = max;
            max = Math.max(max, nums[i]);
            suffix[n - i - 1] = min;
            min = Math.min(min, nums[n - i - 1]);
        }
        for (int i = 1; i < (n - 1); i++){
            if (nums[i] < suffix[i] && nums[i] > prefix[i]) {
                sum += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }
        return sum;
    }
}
