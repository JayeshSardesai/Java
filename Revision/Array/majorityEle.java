// Here majority ele is guarateed.
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int element = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return element;
    }
}

// Here majority element is not guaranteed.
class Solution {
    int majorityElement(int arr[]) {
        // code here
        int cnt = 1;
        int element = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                element = arr[i];
            } else if (arr[i] == element) {
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) cnt++;
        }
        if (cnt > (n / 2))
            return element;
        return -1;
    }
}
