class Solution {
    public void nextPermutation(int[] nums) {
        int in=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                in=i;
                break;
            }
        }
        if(in==-1){
            int i = 0, j = nums.length - 1;
            while (i < j) {
                nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
                i++; j--;
            }
            return;
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[in]){
                nums[i]=nums[i]+nums[in]-(nums[in]=nums[i]);
                break;
            }
        }
        int i = in + 1, j = nums.length - 1;
        while (i < j) {
            nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
            i++; j--;
        }
    }
}
