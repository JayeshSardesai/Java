// Positive and negative numbers same.
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0, neg = 1;
        for(int i = 0;i < n;i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos+=2;
            } else if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg+=2;
            }
        }
        return ans;
    }
}

// Positive and negative numbers are not same.
class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.size();
        for (int i = 0;i < n;i++) {
            if (arr.get(i) < 0) neg.add(arr.get(i));
            else pos.add(arr.get(i));
        }
        int i = 0;
        int j = 0;
        int k = 0;
        n = pos.size();
        int m = neg.size();
        int limit = n < m?n:m;
        while(i < limit && j < limit) {
            arr.set(k++,pos.get(i++));
            arr.set(k++,neg.get(j++));
        }
        while(i < n) {
            arr.set(k++,pos.get(i++));
        }
        while(j < m) {
            arr.set(k++,neg.get(j++));
        }
    }
}
