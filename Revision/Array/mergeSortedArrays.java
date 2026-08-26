class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (nums1[i] > nums2[j]) {
                nums1[i] =  nums1[i] + nums2[j] - (nums2[j] = nums1[i]);
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2, 0, n);
        System.arraycopy (nums2, 0, nums1, m, n);
    }
}
