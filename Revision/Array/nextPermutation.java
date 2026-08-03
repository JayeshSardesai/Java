class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        int j = 0;
        int change = -1;
        while (i >= 0) {
            j = n - 1;
            while (j > i) {
                if (nums[i] < nums[j]) {
                    change = j;
                    break;
                }
                j--;
            }
            if (change != -1) {
                nums[i] =  nums[i] + nums[change] - (nums[change] = nums[i]);
                break;
            }
            i--;
        }
        if (change == -1) {
            i = 0;
        } else {
            i = i + 1;
        }
        j = n - 1;
        while (i < j) {
            nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
            i++;
            j--;
        }
    }
}
