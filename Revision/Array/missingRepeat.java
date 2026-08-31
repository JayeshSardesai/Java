class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        long n = arr.length;
        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;
        long s1 = 0;
        long s2 = 0;
        for (int i = 0; i < n; i++) {
            s1 += arr[i];
            s2 = s2 + ((long)arr[i] * (long)arr[i]);
        }
        long val1 = s1 - sn;
        long val2 = s2 - s2n;
        val2 = val2 / val1;
        long repeat = (val1 + val2) / 2;
        long missing = (repeat - val1);
        ans.add((int)repeat);
        ans.add((int)missing);
        return ans;
    }
}
