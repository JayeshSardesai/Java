// This is for the array which is not rotated.
class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        int n = arr.length;
        int drop = 0;
        for (int  i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                drop++;
            }
        }
        return drop == 0;
    }
}

// This approach is for the array which is rotated.
class Solution {
    public boolean check(int[] nums) {
        int drop = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(n + i + 1) % n]) {
                drop++;
            }
        }
        return drop <= 1;
    }
}
