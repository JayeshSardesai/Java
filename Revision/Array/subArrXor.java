class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        long cnt = 0;
        Map<Integer,Integer> prefixXor = new HashMap<>();
        int n = arr.length;
        int xor = 0;
        prefixXor.put(0,1);
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
            int xr = xor ^ k;
            cnt += prefixXor.getOrDefault(xr, 0);
            prefixXor.put(xor, prefixXor.getOrDefault(xor, 0) + 1);
        }
        return cnt;
    }
}
