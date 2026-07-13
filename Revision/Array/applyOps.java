// If nums[i] == nums[i + 1] then change nums[i]  to nums[i] *= 2 and nums[i + 1] = 0 and move all zeros to end.
class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n - 1) {
            if(nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            i++;
        }
        i = 0;
        int j = 0;
        while(i < n) {
            if (nums[i] == 0){
                i++;
                continue;
            }
            if(nums[i] != 0 && nums[j] == 0){
                nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
            }
            i++;
            j++;
        }
        return nums;
    }
}
