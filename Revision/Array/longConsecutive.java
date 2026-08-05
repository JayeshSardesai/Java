class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        for (Integer element : set) {
            int cnt = 1;
            int temp = element;
            if (!set.contains(temp - 1)) {
                while (set.contains(temp + 1)) {
                    cnt++;
                    temp++;
                }
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
