class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(i < n){
            if(nums[i] == val) {
                i++;
                continue;
            }
            if(nums[i] != val && nums[j] == val) {
                nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
            }
            i++;
            j++;
        }
        return j;
    }
}
