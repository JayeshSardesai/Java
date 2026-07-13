class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(i < n) {
            if(nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[i] != 0 && nums[j] == 0) {
                nums[i] = (nums[i] + nums[j])-(nums[j] = nums[i]);
            }
            i++;
            j++;
        }
    }
}
